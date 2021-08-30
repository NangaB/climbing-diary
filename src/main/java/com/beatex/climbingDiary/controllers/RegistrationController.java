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

@Controller
public class RegistrationController {

    private UserService userService;
    private ClimberService climberService;
    private RoutService routService;
    private RoutClimberService routClimberService;

    public RegistrationController(UserService userService, ClimberService climberService, RoutService routService, RoutClimberService routClimberService) {
        this.userService = userService;
        this.climberService = climberService;
        this.routService = routService;
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
        if(userService.getAllUsers().contains(user.getUsername())){
            return "registration";
        }
        userService.addUser(user);
        //every user is a climber - creating climber
        Climber climber = new Climber();
        climber.setName(user.getUsername());
        climber.setPoints(0);
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
                        @RequestParam(required = false) Long id, @RequestParam (required = false) Boolean flag, @RequestParam(required = false) Boolean flag2){
        Role role = userService.getRole(principal.getName());
        model.addAttribute("role", role.getRole());
        model.addAttribute("name", principal.getName());
        model.addAttribute("flag", flag);
        model.addAttribute("flag2", flag2);
        model.addAttribute("region", region);
        model.addAttribute("routsByRegion", routService.getRoutsByRegion(region));

        Long climberId = climberService.getClimberIdByPrincipal(principal);
        List<RoutClimber> routList = climberService.getAllRoutsForClimber(climberId);
        model.addAttribute("routsClimber", routList);

        List<Climber> ranking = climberService.getRanking();
        model.addAttribute("ranking", ranking);

        return "hello";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/logout";
    }



}
