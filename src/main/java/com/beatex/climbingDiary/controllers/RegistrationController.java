package com.beatex.climbingDiary.controllers;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.model.Role;
import com.beatex.climbingDiary.model.RoutClimber;
import com.beatex.climbingDiary.model.User;
import com.beatex.climbingDiary.service.ClimberService;
import com.beatex.climbingDiary.service.RankingService;
import com.beatex.climbingDiary.service.RoutService;
import com.beatex.climbingDiary.service.UserService;
import org.hibernate.dialect.Ingres9Dialect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {

    private UserService userService;
    private ClimberService climberService;
    private RoutService routService;
    private RankingService rankingService;

    public RegistrationController(UserService userService, ClimberService climberService, RoutService routService, RankingService rankingService) {
        this.userService = userService;
        this.climberService = climberService;
        this.routService = routService;
        this.rankingService = rankingService;
    }

//    Here is start
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/register")
    public String registerForm(){
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute User user){
        userService.addUser(user);
        //every user is a climber - creating climber
        Climber climber = new Climber();
        climber.setName(user.getUsername());
        climberService.addClimber(climber);
        return "redirect:/login";
    }

    @GetMapping("/hello")
    public String hello(Model model, Principal principal){
        Role role = userService.getRole(principal.getName());
        model.addAttribute("role", role.getRole());
        model.addAttribute("name", principal.getName());

        model.addAttribute("allRouts", routService.allRouts());

        Long climberId = climberService.getClimberIdByPrincipal(principal);
        List<RoutClimber> routList = climberService.getAllRoutsForClimber(climberId);
        model.addAttribute("routsClimber", routList);


        Map<String, Integer> rankingByName = rankingService.getRanking();
        model.addAttribute("ranking", rankingByName);

        return "hello";
    }



}
