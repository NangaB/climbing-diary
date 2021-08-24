package com.beatex.climbingDiary.controllers;

import com.beatex.climbingDiary.model.*;
import com.beatex.climbingDiary.service.ClimberService;
import com.beatex.climbingDiary.service.RankingService;
import com.beatex.climbingDiary.service.RoutClimberService;
import com.beatex.climbingDiary.service.RoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class ClimberController {

    private ClimberService climberService;
    private RoutService routService;
    private RoutClimberService routClimberService;
    private RankingService rankingService;

    public ClimberController(ClimberService climberService, RoutClimberService routClimberService, RoutService routService, RankingService rankingService) {
        this.climberService = climberService;
        this.routService = routService;
        this.routClimberService = routClimberService;
        this.rankingService = rankingService;
    }

    //access only for ADMIN
    @GetMapping("/getAllClimbers")
    public String getAllClimbers(Model model){
        model.addAttribute("climbers",climberService.getAllClimbers());
        return "abc";
    }

    //access only for ADMIN
    @PostMapping("/addClimber")
    public String addClimber(@ModelAttribute Climber climber){
        climberService.addClimber(climber);
        return "redirect:/home";
    }

    @GetMapping("/routsForRegion")
    public String getRoutsByRegion(Region region){
        return "redirect:/hello?region=" + region +"&flag=true";
    }

    @PostMapping("/addRoutForClimber")
    public String routForClimber(@ModelAttribute RoutClimber rout, Principal principal){
        Rate rate = routService.getRateByRoutName(rout.getName());
        rout.setRate(rate);
        routClimberService.addRoutClimber(rout);
        Long climberId = climberService.getClimberIdByPrincipal(principal);
        climberService.addRoutForClimber(climberId, rout);
        return "redirect:/hello";
    }

    @GetMapping("/update")
    public String update(@RequestParam Long id){
        return "redirect:/hello?id=" + id;
    }

}
