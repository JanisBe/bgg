package com.janis.bgg.controller;

import com.janis.bgg.entities.entity.Game;
import com.janis.bgg.mapper.GraMapper;
import com.janis.bgg.service.GryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.InvalidParameterException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class GraRestController {

    @Autowired
    private GryService gryService;

    @Autowired
    private GraMapper graMapper;

    @ApiOperation(value = "też pokazuje wszystkie gry")
    @RequestMapping(value = "/gry", method = RequestMethod.GET)
    public List<Game> findByNoOfPlayers(@RequestParam(value = "noOfPlayers") Integer noOfPlayers) {
        List<Game> gameList = gryService.findGameByNumOfPlayers(noOfPlayers);
        return gameList;
    }

    @ApiOperation(value = "pokazuje wszystkie gry")
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> findAll() {
        List<Game> gameList = gryService.findAll();
        return gameList;
    }

    @ApiOperation(value = "pokazuje dane jednej gry")
    @RequestMapping(value = "games/{id}", method = RequestMethod.GET)
    public Game findById(@PathVariable(value = "id") int id) {
        return gryService.findById(id);
    }

    @PostMapping("/games")
    public Game saveGame(@Valid @RequestBody Game game) {
        return gryService.saveGame(game);
    }

    @PutMapping("/games/{id}")
    public Game updateGame(@PathVariable(value = "id") int id, @Valid @RequestBody Game game) {
        Game gra = gryService.findById(id);
        if (gra == null) {
            throw new InvalidParameterException("Gra nieznaleziona");
        }

        return gryService.saveGame(graMapper.gameToGame(game));
    }
}
