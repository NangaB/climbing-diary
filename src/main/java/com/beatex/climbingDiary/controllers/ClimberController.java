package com.beatex.climbingDiary.controllers;

import com.beatex.climbingDiary.model.*;
import com.beatex.climbingDiary.service.*;
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
    private UserService userService;

    public ClimberController(ClimberService climberService, RoutClimberService routClimberService, RoutService routService, RankingService rankingService, UserService userService) {
        this.climberService = climberService;
        this.routService = routService;
        this.routClimberService = routClimberService;
        this.rankingService = rankingService;
        this.userService = userService;
    }

    //access only for ADMIN
    @GetMapping("/getAllClimbers")
    public String getAllClimbers(Model model){
        model.addAttribute("climbers",climberService.getAllClimbers());
        return "climbers";
    }

    @GetMapping("/routsForRegion")
    public String getRoutsByRegion(Region region){
        return "redirect:/hello?region=" + region +"&flag=true" + "&flag2=true";
    }

    @PostMapping("/addRoutForClimber")
    public String routForClimber(@ModelAttribute RoutClimber rout, Principal principal){
        Rate rate = routService.getRateByRoutName(rout.getName());
        rout.setRate(rate);
        Long climberId = climberService.getClimberIdByPrincipal(principal);
        climberService.addRoutForClimber(climberId, rout);
        return "redirect:/hello?flag=true";
    }

    @GetMapping("/deleteRout")
    public String delete(@RequestParam Long id){
        routClimberService.deleteRoutClimberById(id);
        return "redirect:/hello";
    }

    @GetMapping("/deleteClimber")
    public String deleteClimber(@RequestParam Long id){
        climberService.deleteClimber(id);
        userService.deleteUser(id);
        return "redirect:/getAllClimbers";
    }

}
