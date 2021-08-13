package com.beatex.climbingDiary.controllers;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.model.RoutClimber;
import com.beatex.climbingDiary.service.ClimberService;
import com.beatex.climbingDiary.service.RankingService;
import com.beatex.climbingDiary.service.RoutClimberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class ClimberController {

    private ClimberService climberService;
    private RoutClimberService routClimberService;
    private RankingService rankingService;

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
        routClimberService.addRoutClimber(rout);
        Long climberId = climberService.getClimberIdByPrincipal(principal);
        climberService.addRoutForClimber(climberId, rout);
        return "redirect:/hello";
    }

    @GetMapping("/getRoutsForClimber") //almost not used
    public String getRoutsForClimber(Model model, Principal principal){
        Long climberId = climberService.getClimberIdByPrincipal(principal);
        List<RoutClimber> rc = climberService.getAllRoutsForClimber(climberId);
        model.addAttribute("climberRouts", rc);
        return "redirect:/hello";
    }

    @GetMapping("/getRanking") //almost not used
    public String getRanking(Model model){
        Map<String, Integer> ranking = rankingService.getRanking();
        model.addAttribute("ranking", ranking);
        return "redirect:/hello";
    }

    @GetMapping("/abc")
    public String aa(){
        return "abc";
    }
}
