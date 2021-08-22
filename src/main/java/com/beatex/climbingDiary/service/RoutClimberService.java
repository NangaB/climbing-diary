package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.RoutClimber;
import com.beatex.climbingDiary.repository.RoutClimberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RoutClimberService {

    private RoutClimberRepository routClimberRepository;

    public RoutClimberService(RoutClimberRepository routClimberRepository) {
        this.routClimberRepository = routClimberRepository;
    }

    public void addRoutClimber(RoutClimber routClimber){
        routClimberRepository.save(routClimber);
    }

    public RoutClimber findRoutByName(String routName){
        return routClimberRepository.findRoutClimberByName(routName);
    }

    public RoutClimber findRoutById(Long id){
        return routClimberRepository.findRoutClimberById(id);
    }

    @Transactional
    public int deleteRoutClimberById(Long id){
        return routClimberRepository.deleteRoutClimberById(id);
    }
}
