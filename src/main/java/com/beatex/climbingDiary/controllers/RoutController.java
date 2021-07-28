package com.beatex.climbingDiary.controllers;

import com.beatex.climbingDiary.model.Rout;
import com.beatex.climbingDiary.service.ClimberService;
import com.beatex.climbingDiary.service.RoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoutController {

    private RoutService routService;
    private ClimberService climberService;

    public RoutController(RoutService routService, ClimberService climberService) {
        this.routService = routService;
        this.climberService = climberService;
    }

    @GetMapping("/routs")
    public String getAllRouts(Model model){
        model.addAttribute("allRouts", routService.allRouts());
        return "allRouts";
    }

    @GetMapping("/routsClimber")
    public String getAllRoutsForClimber(Model model){
        Long id = 1L; // TU Wróć - to jest id dla akutalnie zalogowanego uzytkownika/climbera
        List<Rout> routs = climberService.getAllRoutsForClimber(id);
        model.addAttribute("routs", routs);
        return "routs";
    }

    @PostMapping("/addRout")
    public String addRout(@ModelAttribute Rout rout){
        routService.addRout(rout);
        return "redirect:/routs";
    }
}
