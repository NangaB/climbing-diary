package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.model.Rout;
import com.beatex.climbingDiary.repository.ClimberRepository;
import org.springframework.stereotype.Service;

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

    public List<Rout> getAllRoutsForClimber(Long id){
        return climberRepository.getClimberById(id).getRoutList();
    }

    public void addClimber(Climber climber){
        climberRepository.save(climber);
    }

    public Climber getClimberByName(String name){
        return climberRepository.getClimberByName(name);
    }

    public void addRoutForClimber(Long id, Rout rout){
        Climber c = climberRepository.getClimberById(id);
        c.addRoutForClimber(rout);
        climberRepository.save(c);
    }


}
