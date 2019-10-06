package com.janis.bgg.demo.controller;

import com.janis.bgg.demo.service.GryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GraController {

    @Autowired
    private GryService gryService;

    @GetMapping("/index")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("name", "IMIEEEE");
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
