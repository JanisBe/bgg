package com.janis.bgg.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.janis.bgg.demo.dao.GryDao;
import com.janis.bgg.demo.dao.GryDescDao;
import com.janis.bgg.demo.dao.SettingsDao;
import com.janis.bgg.demo.entity.Gra;
import com.janis.bgg.demo.entity.GraDescription;
import com.janis.bgg.demo.entity.Settings;
import com.janis.bgg.demo.jsonObjects.JsonGraDescription;
import com.janis.bgg.demo.mapper.GraDescriptionMapper;
import com.janis.bgg.demo.utils.ImporterUtils;
import com.janis.bgg.demo.xml.collection.MyCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

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

    public List<Gra> importGamesFromBgg(String userName) {
        if (StringUtils.isEmptyOrWhitespace(userName)) {
            throw new IllegalArgumentException("userName can't be blank");
        }
        String data = null;
        try {
            data = ImporterUtils.connect("https://api.geekdo.com/xmlapi2/collection?username=" + userName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(data);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(MyCollection.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(data);
            MyCollection collection = (MyCollection) jaxbUnmarshaller.unmarshal(reader);
            int size = collection.getTotalitems().intValue();
            for (int i = 0; i <= size; i++) {
                Integer gameId = collection.getItem().get(i).getObjectid();
                importGameDetails(gameId);
            }
            Settings settings = new Settings(userName, LocalDate.parse(collection.getPubdate()));
            settingsDao.save(settings);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return gryDao.findAll();
    }

    private void importGameDetails(Integer gameId) {
        HttpURLConnection con = null;
        while (true) {
            try {
                if (!(con == null || con.getResponseCode() == 200))
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                URL url = new URL("https://bgg-json.azurewebsites.net/thing/" + gameId);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();
                ObjectMapper mapper = new ObjectMapper();
                JsonGraDescription gra = mapper.readValue(content.toString(), JsonGraDescription.class);
                GraDescription gry = descriptionMapper.mapGraToGry(gra);
                gryDescDao.save(gry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
