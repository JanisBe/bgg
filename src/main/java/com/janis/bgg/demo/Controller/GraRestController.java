package com.janis.bgg.demo.Controller;

import com.janis.bgg.demo.Service.GryService;
import com.janis.bgg.demo.entity.Gra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GraRestController {
    @Autowired
    private GryService service;

    @RequestMapping("/gry")
    public List<Gra> findByNoOfPlayers(@RequestParam(value = "noOfPlayers") Integer noOfPlayers) {
        return service.findGameByNumOfPlayers(noOfPlayers);
    }

    @RequestMapping("/all")
    public List<Gra> findAll() {
        return service.findAll();
    }

}
