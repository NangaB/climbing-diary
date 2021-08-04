package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.Rout;
import com.beatex.climbingDiary.repository.ClimberRepository;
import com.beatex.climbingDiary.repository.RoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutService {

    private final RoutRepository routRepository;
    private final ClimberRepository climberRepository;

    public RoutService(RoutRepository routRepository, ClimberRepository climberRepository) {
        this.routRepository = routRepository;
        this.climberRepository = climberRepository;
    }

    public List<Rout> allRouts(){
        return routRepository.findAll();
    }

    public void addRout(Rout rout){
        routRepository.save(rout);
    }
}
