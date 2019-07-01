package com.janis.bgg.demo.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.janis.bgg.demo.Dao.GryDescDao;
import com.janis.bgg.demo.Service.GryService;
import com.janis.bgg.demo.entity.Gra;
import com.janis.bgg.demo.entity.GraDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GraRestController {
    @Autowired
    private GryService service;
    @Autowired
    private GryDescDao gryDescDao;

    @RequestMapping("/gry")
    public List<Gra> findByNoOfPlayers(@RequestParam(value = "noOfPlayers") Integer noOfPlayers) {
        return service.findGameByNumOfPlayers(noOfPlayers);
    }

    @RequestMapping("/all")
    public List<Gra> findAll() {
        return service.findAll();
    }

    @RequestMapping("/http")
    public String test() throws IOException {
        List<Double> res = new ArrayList<>();
        List<Integer> gryId = service.findAll().stream().map(Gra::getGameId).limit(5).collect(Collectors.toList());
        for (Integer id : gryId) {
            URL url = new URL("https://bgg-json.azurewebsites.net/thing/" + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            ObjectMapper mapper = new ObjectMapper();
            GraDescription gra = mapper.readValue(content.toString(), GraDescription.class);
            gryDescDao.save(gra);
            res.add(gra.getBggRating());
        }

        return res.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

}
