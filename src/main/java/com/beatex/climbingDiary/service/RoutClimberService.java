package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.RoutClimber;
import com.beatex.climbingDiary.repository.RoutClimberRepository;
import org.springframework.stereotype.Service;

@Service
public class RoutClimberService {

    private RoutClimberRepository routClimberRepository;

    public RoutClimberService(RoutClimberRepository routClimberRepository) {
        this.routClimberRepository = routClimberRepository;
    }

    public void addRoutClimber(RoutClimber routClimber){
        routClimberRepository.save(routClimber);
    }
}
