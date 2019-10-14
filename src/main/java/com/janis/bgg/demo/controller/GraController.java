package com.janis.bgg.demo.controller;

import static com.janis.bgg.demo.constants.AppConstants.USERNAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.janis.bgg.demo.dao.SettingsDao;
import com.janis.bgg.demo.entities.entity.Settings;
import com.janis.bgg.demo.service.GryService;

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
}
