package com.beatex.climbingDiary.controllers;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.model.RoutClimber;
import com.beatex.climbingDiary.service.ClimberService;
import com.beatex.climbingDiary.service.RoutClimberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class ClimberController {

    private ClimberService climberService;
    private RoutClimberService routClimberService;

    public ClimberController(ClimberService climberService, RoutClimberService routClimberService) {
        this.climberService = climberService;
        this.routClimberService = routClimberService;

    }

    @GetMapping("/getAllClimbers")
    public String home(Model model){
        model.addAttribute("climbers",climberService.getAllClimbers());
        return "index";
    }

    @PostMapping("/addClimber")
    public String addClimber(@ModelAttribute Climber climber){
        climberService.addClimber(climber);
        return "redirect:/home";
    }

    @PostMapping("/addRoutForClimber")
    public String routForClimber(RoutClimber rout, Principal principal){
        String name = principal.getName();
        if(name == null){
            System.out.println("NAME is Null");
            return "abc";
        }
        routClimberService.addRoutClimber(rout);
        Climber climber = climberService.getClimberByName(name);
        climberService.addRoutForClimber(climber.getId(), rout);
        return "abc";
    }

    @GetMapping("/showDiary")
    public String getClimberRouts(Model model, Principal principal){
        Climber climber = climberService.getClimberByName(principal.getName());
        List<RoutClimber> routList = climberService.getAllRoutsForClimber(climber.getId());
        model.addAttribute("routsClimber", routList);
        System.out.println(routList);
        return "redirect:/hello";
    }

    @GetMapping("/abc")
    public String aa(){
        return "abc";
    }
}
