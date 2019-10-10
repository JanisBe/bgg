package com.janis.bgg.demo.controller;

import static com.janis.bgg.demo.constants.AppConstants.JSON_THING;
import static com.janis.bgg.demo.constants.AppConstants.XML_COLLECTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.janis.bgg.demo.dao.GryDescDao;
import com.janis.bgg.demo.entity.Game;
import com.janis.bgg.demo.entity.Gra;
import com.janis.bgg.demo.jsonObjects.JsonGraDescription;
import com.janis.bgg.demo.mapper.CollectionToGameMapper;
import com.janis.bgg.demo.mapper.GraDescriptionMapper;
import com.janis.bgg.demo.mapper.ItemMapper;
import com.janis.bgg.demo.service.GryService;
import com.janis.bgg.demo.service.ImportService;
import com.janis.bgg.demo.utils.ImporterUtils;
import com.janis.bgg.demo.xml.Items3.Items;
import com.janis.bgg.demo.xml.collection.MyCollection;

@RestController
public class GraRestController {
    private final GryService gryService;
    private final ImportService importService;
    private final GryDescDao gryDescDao;
    private final GraDescriptionMapper descriptionMapper;
    private final ItemMapper itemMapper;
    private final CollectionToGameMapper collectionMapper;

    public GraRestController(GryService gryService, ImportService importService, GryDescDao gryDescDao, GraDescriptionMapper descriptionMapper, ItemMapper itemMapper, CollectionToGameMapper collectionMapper) {
        this.gryService = gryService;
        this.importService = importService;
        this.gryDescDao = gryDescDao;
        this.descriptionMapper = descriptionMapper;
        this.itemMapper = itemMapper;
        this.collectionMapper = collectionMapper;
    }

    @RequestMapping("/gry")
    public List<Gra> findByNoOfPlayers(@RequestParam(value = "noOfPlayers") Integer noOfPlayers) {
        return gryService.findGameByNumOfPlayers(noOfPlayers);
    }

    @RequestMapping("/alles")
    public List<Gra> findAll() {
        return gryService.findAll();
    }

    @RequestMapping("/http")
    public String test() {
        HttpURLConnection con = null;
        List<Double> res = Lists.newArrayList();
        List<Integer> gryId = gryService.findAll().stream().map(Gra::getGameId).limit(10).collect(Collectors.toList());
        for (Integer id : gryId) {
            while (true) {
                try {
                    if (!(con == null || con.getResponseCode() == 200))
                        break;
                } catch (IOException e) {
                    System.out.println("nie działa dla id = " + id);
                    e.printStackTrace();
                }
                try {
                    URL url = new URL(JSON_THING + id);
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

                    Game gry = descriptionMapper.mapGraToGry(gra);
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

    @RequestMapping(value = "/import/{userName}", method = RequestMethod.GET)
    public ModelAndView importMyGames(@PathVariable("userName") String userName) {
        ModelAndView model = new ModelAndView();
        model.addObject("gry", importService.importGamesFromBgg(userName));
        model.setViewName("gry");
        return model;
    }

    @RequestMapping("1")
    public String testy() throws IOException, InterruptedException {
        String data = ImporterUtils.connect("https://api.geekdo.com/xmlapi2/thing?id=221918&stats=1");
        System.out.println(data);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Items.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(data);
            Items item = (Items) jaxbUnmarshaller.unmarshal(reader);

            System.out.println(item);
            Game gra = itemMapper.itemToGraMapper(item.getItem());
            System.out.println(gra);
            Game game = gryDescDao.save(gra);
            System.out.println(game);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("2")
    public String collection() throws IOException, InterruptedException {
        String data = ImporterUtils.connect(XML_COLLECTION + "janislav");
        System.out.println(data);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(MyCollection.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(data);
            MyCollection item = (MyCollection) jaxbUnmarshaller.unmarshal(reader);

            System.out.println(item);
            Gra gra = collectionMapper.mapCollectionToGra(item.getItem().get(6));
            System.out.println(gra);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ExceptionHandler
    public ModelAndView handleErrors(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("error");
        return modelAndView;
    }
}