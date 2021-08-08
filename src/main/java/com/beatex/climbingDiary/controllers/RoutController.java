package com.beatex.climbingDiary.controllers;

import com.beatex.climbingDiary.model.Rout;
import com.beatex.climbingDiary.service.ClimberService;
import com.beatex.climbingDiary.service.RoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RoutController {

    private RoutService routService;

    public RoutController(RoutService routService) {
        this.routService = routService;
    }

    @GetMapping("/routs")
    public String getAllRouts(Model model){
        model.addAttribute("allRouts", routService.allRouts());
        return "routs";
    }

    //access only for admin
    @GetMapping("/addRout")
    public String addRout(Model model, @RequestParam(required = false) String info){
        Rout rout = new Rout();
        model.addAttribute("rout", rout);
        if(info != null){
            model.addAttribute("info", info);
        }
        model.addAttribute("routs", routService.allRouts());
        return "routs";
    }

    @PostMapping("/addRout")
    public String addRout(@ModelAttribute Rout rout){
        routService.addRout(rout);
        return "redirect:/addRout?info=Dodano nową drogę w rejonie " + rout.getRegion();
    }
}
