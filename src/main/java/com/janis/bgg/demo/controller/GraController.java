package com.janis.bgg.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.janis.bgg.demo.service.GryService;

@Controller
public class GraController {

    @Autowired
    private GryService gryService;

    @GetMapping("/")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("name", "asd");
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
