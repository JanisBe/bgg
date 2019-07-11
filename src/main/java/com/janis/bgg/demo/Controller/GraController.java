package com.janis.bgg.demo.Controller;

import com.janis.bgg.demo.Entity.Gra;
import com.janis.bgg.demo.Service.GryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GraController {

    @Autowired
    private GryService serwis;

    @GetMapping("/index")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("name", "IMIEEEE");
        return modelAndView;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("dupa", "dupa");
        return "results";
    }

    @GetMapping("/playagame")
    public ModelAndView isWIn(@RequestParam("choice") String choice) {
        ModelAndView model = new ModelAndView();
        model.addObject("name", choice);
        model.addObject("dupa", "dupa");
        model.setViewName("results");
        return model;
    }

    @GetMapping("/all")
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView();
        List<Gra> gry = serwis.findAll();
        modelAndView.addObject("gry", gry);
        modelAndView.setViewName("gry");
        return modelAndView;
    }

    @GetMapping("/gracz")
    public ModelAndView noOfPlayers(@RequestParam("choice") Integer num) {
        ModelAndView modelAndView = new ModelAndView();
        List<Gra> gry = serwis.findGracze(num);
        modelAndView.addObject("gry", gry);
        modelAndView.setViewName("gry");
        return modelAndView;
    }
}
