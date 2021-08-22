package com.beatex.climbingDiary.controllers;

import com.beatex.climbingDiary.model.*;
import com.beatex.climbingDiary.service.*;
import org.hibernate.dialect.Ingres9Dialect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {

    private UserService userService;
    private ClimberService climberService;
    private RoutService routService;
    private RoutClimberService routClimberService;
    private RankingService rankingService;

    public RegistrationController(UserService userService, ClimberService climberService, RoutService routService, RankingService rankingService, RoutClimberService routClimberService) {
        this.userService = userService;
        this.climberService = climberService;
        this.routService = routService;
        this.rankingService = rankingService;
        this.routClimberService = routClimberService;
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

    @GetMapping("/flag")
    public String flag(){
        Boolean flag = true;
        return "redirect:/hello?flag=" + flag;
    }

    @GetMapping("/hello")
    public String hello(Model model, Principal principal, @RequestParam(required = false) Region region,
                        @RequestParam(required = false) Long id, @RequestParam (required = false) Boolean flag){
        Role role = userService.getRole(principal.getName());
        model.addAttribute("role", role.getRole());
        model.addAttribute("name", principal.getName());

        model.addAttribute("flag", flag);
        model.addAttribute("region", region);
        model.addAttribute("routsByRegion", routService.getRoutsByRegion(region));

        Long climberId = climberService.getClimberIdByPrincipal(principal);
        List<RoutClimber> routList = climberService.getAllRoutsForClimber(climberId);
        model.addAttribute("routsClimber", routList);

        RoutClimber routClimber = routClimberService.findRoutById(id);
        model.addAttribute("updated", routClimber);

        Map<String, Integer> rankingByName = rankingService.getRanking();
        model.addAttribute("ranking", rankingByName);

        return "hello";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/logout";
    }



}
