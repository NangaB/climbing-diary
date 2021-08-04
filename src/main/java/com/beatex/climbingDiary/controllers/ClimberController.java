package com.beatex.climbingDiary.controllers;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.model.Rout;
import com.beatex.climbingDiary.service.ClimberService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ClimberController {

    private ClimberService climberService;

    public ClimberController(ClimberService climberService) {
        this.climberService = climberService;
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
    public String routForClimber(@ModelAttribute Rout rout, Principal principal){
        String name = principal.getName();
        if(name == null){
            System.out.println("NAME is Null");
            return "abc";
        }
        Climber climber = climberService.getClimberByName(name);
        climberService.addRoutForClimber(climber.getId(), rout);
        return "abc";
    }
}
