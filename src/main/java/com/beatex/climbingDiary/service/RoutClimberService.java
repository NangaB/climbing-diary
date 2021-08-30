package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.model.RoutClimber;
import com.beatex.climbingDiary.repository.ClimberRepository;
import com.beatex.climbingDiary.repository.RoutClimberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RoutClimberService {

    private RoutClimberRepository routClimberRepository;
    private ClimberRepository climberRepository;
    private ClimberService climberService;


    public RoutClimberService(RoutClimberRepository routClimberRepository,ClimberRepository climberRepository, ClimberService climberService) {
        this.routClimberRepository = routClimberRepository;
        this.climberRepository = climberRepository;
        this.climberService = climberService;
    }


    @Transactional
    public int deleteRoutClimberById(Long id){
        RoutClimber rout =routClimberRepository.findClimberIdByRoutId(id);
        int points = climberService.getSumePointsForClimber(rout.getClimber().getId()) - rout.getRate().getPoints();
        Climber climber = climberRepository.getClimberById(rout.getClimber().getId());
        climber.setPoints(points);
        climberRepository.save(climber);
        return routClimberRepository.deleteRoutClimberById(id);
    }
}
