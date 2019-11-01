package com.janis.bgg.controller;

import com.janis.bgg.dao.SettingsDao;
import com.janis.bgg.entities.dto.GraDto;
import com.janis.bgg.entities.dto.SearchCriteria;
import com.janis.bgg.entities.entity.Settings;
import com.janis.bgg.service.GryService;
import com.janis.bgg.service.ImportService;
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

    @GetMapping("/")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        Settings userName = settingsDao.findByName(USERNAME);
        String name = userName != null ? userName.getContent() : "";
        modelAndView.addObject("username", name);
        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("gry", gryService.findAll());
        modelAndView.setViewName("gry");
        return modelAndView;
    }

    @GetMapping(value = "/import")
    public ModelAndView importMyGames(@RequestParam(value = "userName", required = false) String userName) {
        ModelAndView model = new ModelAndView();
        List<GraDto> allGames = importService.importGamesFromBgg(userName);
        model.addObject("gry", allGames);
        model.setViewName("gry");
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

    @ExceptionHandler
    public ModelAndView handleErrors(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("error");
        return modelAndView;
    }
}
