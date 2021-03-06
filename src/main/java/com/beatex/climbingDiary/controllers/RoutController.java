package com.beatex.climbingDiary.controllers;

import com.beatex.climbingDiary.dtos.RoutDto;
import com.beatex.climbingDiary.service.RoutClimberService;
import com.beatex.climbingDiary.service.RoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class RoutController {

    private RoutService routService;
    private RoutClimberService routClimberService;

    public RoutController(RoutService routService, RoutClimberService routClimberService) {
        this.routService = routService;
        this.routClimberService = routClimberService;
    }

    //access only for admin
    @GetMapping("/addRout")
    public String addRout(Model model, @RequestParam(required = false) String info){
        if(info != null){
            model.addAttribute("info", info);
        }
        model.addAttribute("routs", routService.allRouts());
        return "routs";
    }

    //access only for admin
    @PostMapping("/addRout")
    public String addRout(@ModelAttribute RoutDto routDto){
        routService.addRout(routDto);
        return "redirect:/addRout?info=Dodano nowa droge w rejonie " + routDto.getRegion();
    }

    //access only for admin
    @GetMapping("/delete")
    public String deletRout(@RequestParam String name){
        routService.deleteRoutByName(name);
        return "redirect:/addRout";
    }

}
