package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.model.Rate;
import com.beatex.climbingDiary.model.RoutClimber;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RankingService {

    private RoutClimberService routClimberService;
    private ClimberService climberService;

    public RankingService(RoutClimberService routClimberService, ClimberService climberService) {
        this.routClimberService = routClimberService;
        this.climberService = climberService;
    }

    public int getPoints(Long climberId){
        Climber climber = climberService.getClimberById(climberId);
        List<RoutClimber> rc = climber.getRouts();
        if(rc.isEmpty()){
            return 0;
        }
        List<Integer> p = rc.stream().map(r ->r.getRate().getPoints()).collect(Collectors.toList());
        return p.stream().reduce(0, Integer::sum);
    }

    public void addPoints(Long climberId){
        Climber climber = climberService.getClimberById(climberId);
        int points = climber.getPoints();
        List<RoutClimber> rc = climber.getRouts();
        if(rc.isEmpty()){
            climber.setPoints(points);
        }else {
            List<Integer> p = rc.stream().map(r -> r.getRate().getPoints()).collect(Collectors.toList());
            points = p.stream().reduce(0, Integer::sum);
            climber.setPoints(points);
        }
    }

    public Map<String, Integer> getRanking(){
        List<Climber> climbers = climberService.getAllClimbers();
        List<Integer> points = climbers.stream().map(c->getPoints(c.getId())).collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<climbers.size(); i++){
            map.put(climbers.get(i).getName(), points.get(i));
        }
        return map;
    }
}
