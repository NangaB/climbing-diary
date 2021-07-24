package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.repository.ClimberRepository;
import org.springframework.stereotype.Service;

@Service
public class ClimberService {

    ClimberRepository climberRepository;

    public ClimberService(ClimberRepository climberRepository) {
        this.climberRepository = climberRepository;
    }

    public void addClimber(Climber climber){
        climberRepository.save(climber);
    }
}
