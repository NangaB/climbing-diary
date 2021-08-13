package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.model.Rout;
import com.beatex.climbingDiary.model.RoutClimber;
import com.beatex.climbingDiary.model.User;
import com.beatex.climbingDiary.repository.ClimberRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class ClimberService {

    private final ClimberRepository climberRepository;

    public ClimberService(ClimberRepository climberRepository) {
        this.climberRepository = climberRepository;
    }

    public List<Climber> getAllClimbers(){
        return climberRepository.findAll();
    }

    public List<RoutClimber> getAllRoutsForClimber(Long climberId){
        return climberRepository.getClimberById(climberId).getRouts();
    }

    public void addClimber(Climber climber){
        climberRepository.save(climber);
    }

    public Climber getClimberByName(String name){
        return climberRepository.getClimberByName(name);
    }

    public Climber getClimberById(Long id){
        return climberRepository.getClimberById(id);
    }

    public Long getClimberIdByPrincipal(Principal principal){
        return climberRepository.getClimberIdByName(principal.getName());
    }

    public void addRoutForClimber(Long climberId, RoutClimber rout){
        Climber climber = climberRepository.getClimberById(climberId);
        climber.addRout(rout);
        climberRepository.save(climber);
    }
}
