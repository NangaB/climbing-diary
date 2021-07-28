package com.beatex.climbingDiary.controllers;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.service.ClimberService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClimberController {

    private ClimberService climberService;

    public ClimberController(ClimberService climberService) {
        this.climberService = climberService;
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("climbers",climberService.getAllClimbers());
        return "index";
    }

    @PostMapping("/addClimber")
    public String addClimber(@ModelAttribute Climber climber){
        climberService.addClimber(climber);
        return "redirect:/home";
    }

    @GetMapping("/all")
    public String hello() {
        return "abc";
    }

    @GetMapping("/secured/all")
    public String helloSecured() {
        return "abc";
    }


}
