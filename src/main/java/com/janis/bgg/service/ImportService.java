package com.janis.bgg.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.janis.bgg.dao.GryDao;
import com.janis.bgg.dao.GryDescDao;
import com.janis.bgg.dao.SettingsDao;
import com.janis.bgg.entities.dto.GraDto;
import com.janis.bgg.entities.entity.Game;
import com.janis.bgg.entities.entity.Settings;
import com.janis.bgg.entities.jsonObjects.JsonGraDescription;
import com.janis.bgg.entities.xml.Items3.Items;
import com.janis.bgg.entities.xml.collection.Item;
import com.janis.bgg.entities.xml.collection.MyCollection;
import com.janis.bgg.mapper.GraDescriptionMapper;
import com.janis.bgg.mapper.GraMapper;
import com.janis.bgg.mapper.ItemMapper;
import com.janis.bgg.utils.ImporterUtils;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.janis.bgg.constants.AppConstants.*;

@Service
public class ImportService {
    private final GryDescDao gryDescDao;
    private final SettingsDao settingsDao;
    private final GraDescriptionMapper descriptionMapper;
    private final ItemMapper itemMapper;
    private final GraMapper graMapper;

    public ImportService(ImporterUtils importer, GryDao gryDao, GryDescDao gryDescDao, SettingsDao settingsDao, GraDescriptionMapper descriptionMapper, ItemMapper itemMapper, GraMapper graMapper) {
        this.gryDescDao = gryDescDao;
        this.settingsDao = settingsDao;
        this.descriptionMapper = descriptionMapper;
        this.itemMapper = itemMapper;
        this.graMapper = graMapper;
    }

    public List<GraDto> importGamesFromBgg(String userName) {
        if (StringUtils.isEmptyOrWhitespace(userName)) {
            throw new IllegalArgumentException("userName can't be blank");
        }
        String data = null;
        try {
            data = ImporterUtils.connect(XML_COLLECTION + userName);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(MyCollection.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(data);
            MyCollection collection = (MyCollection) jaxbUnmarshaller.unmarshal(reader);
            List<Integer> bggGameIds = collection.getItem().stream().map(Item::getObjectid).collect(Collectors.toList());
            List<Integer> dbGameIds = Optional.ofNullable(gryDescDao.findAll().stream().map(Game::getId).collect(Collectors.toList()))
                    .orElse(Collections.EMPTY_LIST);
            List<Integer> difference = compareBGGvsDB(bggGameIds, dbGameIds);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z").withLocale(Locale.ENGLISH);
            Settings lastUpdate = Optional.ofNullable(settingsDao.findByName(UPDATE_TIME)).orElse(new Settings());
            String lastUpdateString = lastUpdate.getContent();
            long diffInDays = 100L;
            if (lastUpdateString != null) {
                LocalDate lastUpdateDate = LocalDate.parse(lastUpdateString, formatter);
                diffInDays = ChronoUnit.DAYS.between(lastUpdateDate, LocalDate.now());
            }
            if (!difference.isEmpty() || diffInDays > 20L) {
                int size = collection.getTotalitems().intValue();

                for (int i = 0; i < size; i++) {
                    Integer gameId = collection.getItem().get(i).getObjectid();
                    Game existingGame = gryDescDao.findByGameId(gameId);
                    if (existingGame == null) {
                        importGameDetailsFromXML(gameId);
                    }
                }
                if (settingsDao.findByName(USERNAME).getContent().equals(userName)) {
                    lastUpdate.setContent(collection.getPubdate());
                } else {
                    settingsDao.save(new Settings(USERNAME, userName));
                    settingsDao.save(new Settings(UPDATE_TIME, collection.getPubdate()));
                }
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return graMapper.gameToGraDto(gryDescDao.findAll());
    }

    private void importGameDetailsFromJson(Integer gameId) {
        try {
            String data = ImporterUtils.connect(JSON_THING + gameId);
            ObjectMapper mapper = new ObjectMapper();
            JsonGraDescription gra = mapper.readValue(data, JsonGraDescription.class);
            Game game = descriptionMapper.mapGraToGry(gra);
            gryDescDao.save(game);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void importGameDetailsFromXML(Integer gameId) {
        String data = "";
        try {
            data = ImporterUtils.connect(XML_THING + gameId + STATS);
//            zapisz(data, gameId);
            JAXBContext jaxbContext = JAXBContext.newInstance(Items.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(data);
            Items item = (Items) jaxbUnmarshaller.unmarshal(reader);
            Game gry = itemMapper.itemToGraMapper(item.getItem());
            gryDescDao.save(gry);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println(data);
                zapisz(data, gameId);
            } catch (Exception ex) {
//                ex.printStackTrace();
            }
            System.out.println("!!!!! wywaliło na " + gameId);
        }

    }

    private void zapisz(String readerData, Integer id) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(id + ".txt");
        zapis.println(readerData);
        zapis.close();
    }

    private List<Integer> compareBGGvsDB(List<Integer> bggList, List<Integer> dbList) {
        bggList.removeAll(dbList);
        return bggList;
    }
}
