package com.janis.bgg.demo.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.janis.bgg.demo.Dao.GryDescDao;
import com.janis.bgg.demo.Entity.Gra;
import com.janis.bgg.demo.Entity.GraDescription;
import com.janis.bgg.demo.JsonObjects.JsonGraDescription;
import com.janis.bgg.demo.Mapper.GraDescriptionMapper;
import com.janis.bgg.demo.Service.GryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GraRestController {
    @Autowired
    private GryService service;
    @Autowired
    private GryDescDao gryDescDao;
    @Autowired
    private GraDescriptionMapper descriptionMapper;


    @RequestMapping("/gry")
    public List<Gra> findByNoOfPlayers(@RequestParam(value = "noOfPlayers") Integer noOfPlayers) {
        return service.findGameByNumOfPlayers(noOfPlayers);
    }

    @RequestMapping("/alles")
    public List<Gra> findAll() {
        return service.findAll();
    }

    @RequestMapping("/http")
    public String test() throws IOException {
        HttpURLConnection con = null;
        List<Double> res = Lists.newArrayList();
        // List<Integer> gryId = IntStream.of(92539,173346, 202976, 68448).boxed().collect(Collectors.toList());
        List<Integer> gryId = service.findAll().stream().map(Gra::getGameId).limit(10).collect(Collectors.toList());
        for (Integer id : gryId) {
            while (con == null || con.getResponseCode() == 200) {
                try {
                    URL url = new URL("https://bgg-json.azurewebsites.net/thing/" + id);
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
                    res.add(gra.getBggRating());
                    break;
                } catch (IOException e) {
                    System.out.println("nie działa dla id = " + id);
                    e.printStackTrace();
                    // continue;
                }
            }
        }

        return res.stream().map(Object::toString)
                .collect(Collectors.joining("<br>"));
    }

}
