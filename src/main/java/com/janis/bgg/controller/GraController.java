package com.janis.bgg.controller;

import com.janis.bgg.dao.GryDescDao;
import com.janis.bgg.dao.SettingsDao;
import com.janis.bgg.entities.dto.GraDto;
import com.janis.bgg.entities.dto.SearchCriteria;
import com.janis.bgg.entities.entity.Game;
import com.janis.bgg.entities.entity.Settings;
import com.janis.bgg.mapper.GraMapper;
import com.janis.bgg.service.GryService;
import com.janis.bgg.service.ImportService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.janis.bgg.constants.AppConstants.USERNAME;

@Controller
public class GraController {

    @Autowired
    private GryService gryService;

    @Autowired
    private ImportService importService;

    @Autowired
    private SettingsDao settingsDao;

    @Autowired
    private GryDescDao gryDescDao;

    @Autowired
    private GraMapper graMapper;

    @GetMapping("/")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        addUserName(modelAndView);
        return modelAndView;
    }

    private void addUserName(ModelAndView modelAndView) {
        Settings userName = settingsDao.findByName(USERNAME);
        String name = userName != null ? userName.getContent() : "";
        modelAndView.addObject("userName", name);
        modelAndView.addObject("searchCriteria", new SearchCriteria());
    }

    @GetMapping("/all")
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView();
        List<GraDto> allGames = graMapper.gameToGraDto(gryDescDao.findAll());
        modelAndView.addObject("gry", allGames);
        modelAndView.setViewName("gry");
        addUserName(modelAndView);
        return modelAndView;
    }

    @RequestMapping("/gra/{id}")
    public ModelAndView editGame(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gra");
        GraDto graDto = graMapper.gameToGraDto(gryDescDao.findByGameId(id));
        modelAndView.addObject("game", graDto);
        addUserName(modelAndView);
        return modelAndView;
    }

    @GetMapping(value = "/import")
    public ModelAndView importMyGames(@RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "all", required = false) boolean all) {
        ModelAndView model = new ModelAndView();
        List<GraDto> allGames = importService.importGamesFromBgg(userName, all);
        model.addObject("gry", allGames);
        model.setViewName("gry");
        addUserName(model);
        model.addObject("userName", "janislav");
        return model;
    }

    @GetMapping(value = "/search")
    public ModelAndView searchForm() {
        ModelAndView model = new ModelAndView();
        model.addObject("searchCriteria", new SearchCriteria());
        model.setViewName("search");
        return model;
    }

    @PostMapping(value = "/search")
    public ModelAndView searchForm(@ModelAttribute SearchCriteria searchCriteria) {
        ModelAndView model = new ModelAndView();
        model.setViewName("gry");
        model.addObject("searchCriteria", searchCriteria);
        List<GraDto> foundGames = gryService.findAllGamesToDto(searchCriteria);
        model.addObject("gry", foundGames);
        return model;
    }

    @PostMapping(value = "/saveGame")
    public ModelAndView saveGame(@ModelAttribute GraDto gameDetails) {
        ModelAndView model = new ModelAndView();
        model.setViewName("gry");
        Game updatedGame = graMapper.gameToGame(graMapper.graDtoToGraDesc(gameDetails));
//        gryDescDao.save(updatedGame);
        addUserName(model);
        model.addObject("gry", graMapper.gameToGraDto(gryDescDao.findAll()));
        return model;
    }

    @ExceptionHandler
    public ModelAndView handleErrors(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("trace", ExceptionUtils.getStackTrace(ex));
        modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("error");
        return modelAndView;
    }
}
