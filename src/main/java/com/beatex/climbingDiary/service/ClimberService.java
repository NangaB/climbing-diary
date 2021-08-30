package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.model.RoutClimber;
import com.beatex.climbingDiary.repository.ClimberRepository;
import com.beatex.climbingDiary.repository.RoutClimberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

@Service
public class ClimberService {

    private final ClimberRepository climberRepository;
    private final RoutClimberRepository routClimberRepository;

    public ClimberService(ClimberRepository climberRepository, RoutClimberRepository routClimberRepository) {
        this.climberRepository = climberRepository;
        this.routClimberRepository = routClimberRepository;
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


    public Climber getClimberById(Long id){
        return climberRepository.getClimberById(id);
    }

    public Long getClimberIdByPrincipal(Principal principal){
        return climberRepository.getClimberIdByName(principal.getName());
    }

    public void addRoutForClimber(Long climberId, RoutClimber rout){
        Climber climber = climberRepository.getClimberById(climberId);
        int points = getSumePointsForClimber(climberId) + rout.getRate().getPoints();
        climber.setPoints(points);
        climberRepository.save(climber);
        rout.setClimber(climber);
        routClimberRepository.save(rout);
    }

    public int getSumePointsForClimber(Long climberId){
        Climber climber = getClimberById(climberId);
        return climber.getPoints();
    }

    public List<Climber> getRanking(){
        return climberRepository.getAllClimbersSorted();
    }

    @Transactional
    public void deleteClimber(Long id){
        climberRepository.deleteClimber(id);
    }
}

