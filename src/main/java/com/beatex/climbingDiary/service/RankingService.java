package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.model.Climber;
import com.beatex.climbingDiary.model.Rate;
import com.beatex.climbingDiary.model.RoutClimber;
import org.springframework.stereotype.Service;

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
//        Stream<Rate> rcStream = rc.stream().map(r->r.getRate());
//        System.out.println(rcStream.collect(Collectors.summarizingDouble(Rate::getPoints)));
//        Integer p = rcStream.collect(Collectors.summarizingInt(Rate::getPoints));

//        List<Integer> p = rc.stream().map(r->r.getRate().getPoints()).collect(Collectors.toList());
        return rc.stream().map(r->r.getRate().getPoints()).reduce(0, Integer::sum);
    }

    public Map<String, Integer> getRanking(){
        System.out.println("addfdfd");
        List<Climber> climbers = climberService.getAllClimbers();
        List<Integer> points = climbers.stream().map(c->getPoints(c.getId())).collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<climbers.size(); i++){
            map.put(climbers.get(i).getName(), points.get(i));
        }
        System.out.println(map.size());
        return map;
    }
}
