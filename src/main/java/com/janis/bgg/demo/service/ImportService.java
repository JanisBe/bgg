package com.janis.bgg.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.janis.bgg.demo.dao.GryDao;
import com.janis.bgg.demo.dao.GryDescDao;
import com.janis.bgg.demo.dao.SettingsDao;
import com.janis.bgg.demo.entity.Game;
import com.janis.bgg.demo.entity.Gra;
import com.janis.bgg.demo.entity.Settings;
import com.janis.bgg.demo.jsonObjects.JsonGraDescription;
import com.janis.bgg.demo.mapper.GraDescriptionMapper;
import com.janis.bgg.demo.mapper.GraMapper;
import com.janis.bgg.demo.mapper.ItemMapper;
import com.janis.bgg.demo.utils.ImporterUtils;
import com.janis.bgg.demo.xml.Items3.Items;
import com.janis.bgg.demo.xml.collection.Item;
import com.janis.bgg.demo.xml.collection.MyCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.janis.bgg.demo.constants.AppConstants.*;

@Service
public class ImportService {
    @Autowired
    private ImporterUtils importer;
    @Autowired
    private GryDao gryDao;
    @Autowired
    private GryDescDao gryDescDao;
    @Autowired
    private SettingsDao settingsDao;
    @Autowired
    private GraDescriptionMapper descriptionMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private GraMapper graMapper;

    public List<Gra> importGamesFromBgg(String userName) {
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
            if (!difference.isEmpty()) {
                int size = collection.getTotalitems().intValue();

                for (int i = 0; i < size; i++) {
                    Integer gameId = collection.getItem().get(i).getObjectid();
                    importGameDetailsFromXML(gameId);
                }
            }

            if (settingsDao.findByName(USERNAME).getContent().equals(userName)) {
                settingsDao.findByName(UPDATE_TIME).setContent(collection.getPubdate());
            } else {
                settingsDao.save(new Settings(USERNAME, userName));
                settingsDao.save(new Settings(UPDATE_TIME, collection.getPubdate()));
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return graMapper.graDescToGra(gryDescDao.findAll());
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
        try {
            String data = ImporterUtils.connect(XML_THING + gameId + STATS);
            JAXBContext jaxbContext = JAXBContext.newInstance(Items.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(data);
            Items item = (Items) jaxbUnmarshaller.unmarshal(reader);
            Game gry = itemMapper.itemToGraMapper(item.getItem());
            gryDescDao.save(gry);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("!!!!! wywaliło na " + gameId);
        }

    }

    private List<Integer> compareBGGvsDB(List<Integer> bggList, List<Integer> dbList) {
        bggList.removeAll(dbList);
        return bggList;
    }
}
