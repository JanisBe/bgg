package com.janis.bgg.demo.controller;

import com.janis.bgg.demo.dao.SettingsDao;
import com.janis.bgg.demo.service.GryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static com.janis.bgg.demo.constants.AppConstants.USERNAME;

@Controller
public class GraController {

    @Autowired
    private GryService gryService;

    @Autowired
    private SettingsDao settingsDao;

    @GetMapping("/")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        String name = settingsDao.findByName(USERNAME).getContent();
        modelAndView.addObject("username", Optional.ofNullable(name).orElse(""));
        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("gry", gryService.findAll());
        modelAndView.setViewName("gry");
        return modelAndView;
    }
}
