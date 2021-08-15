package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.Rate;
import com.beatex.climbingDiary.model.Region;
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

    public List<Rout> getRoutsByRegion(Region region){
        return routRepository.findRoutByRegion(region);
    }

    public Rate getRateByRoutName(String routName){
        System.out.println(routRepository.getRateByName(routName));
        return routRepository.getRateByName(routName);
    }

    public void addRout(Rout rout){
        routRepository.save(rout);
    }
}
