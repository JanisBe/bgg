package com.janis.bgg.controller;

import com.janis.bgg.entities.entity.Gra;
import com.janis.bgg.service.GryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GraRestController {

    @Autowired
    private GryService gryService;

    @ApiOperation(value = "też pokazuje wszystkie gry")
    @RequestMapping(value = "/gry", method = RequestMethod.GET)
    public List<Gra> findByNoOfPlayers(@RequestParam(value = "noOfPlayers") Integer noOfPlayers) {
        return gryService.findGameByNumOfPlayers(noOfPlayers);
    }

    @ApiOperation(value = "pokazuje wszystkie gry")
    @RequestMapping(value = "/alles", method = RequestMethod.GET)
    public List<Gra> findAll() {
        return gryService.findAll();
    }
}
