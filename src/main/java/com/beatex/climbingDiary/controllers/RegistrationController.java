package com.beatex.climbingDiary.controllers;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.model.Role;
import com.beatex.climbingDiary.model.User;
import com.beatex.climbingDiary.service.ClimberService;
import com.beatex.climbingDiary.service.RoutService;
import com.beatex.climbingDiary.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class RegistrationController {

    private UserService userService;
    private ClimberService climberService;
    private RoutService routService;

    public RegistrationController(UserService userService, ClimberService climberService, RoutService routService) {
        this.userService = userService;
        this.climberService = climberService;
        this.routService = routService;
    }

//    Here is start
    @GetMapping("/home")
    public String user(){
        return "home";
    }

    @GetMapping("/register")
    public String registerForm(){
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistration(User user){
        userService.addUser(user);
        //every user is a climber - creating climber
        Climber climber = new Climber();
        climber.setName(user.getUsername());
        climberService.addClimber(climber);
        return "redirect:/login";
    }

    @GetMapping("/hello")
    public String login(Model model, Principal principal){
        Role role = userService.getRole(principal.getName());
        model.addAttribute("role", role.getRole());
        model.addAttribute("name", principal.getName());
        model.addAttribute("allRouts", routService.allRouts());
        return "hello";
    }



}
