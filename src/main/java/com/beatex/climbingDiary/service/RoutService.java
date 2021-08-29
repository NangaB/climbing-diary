package com.beatex.climbingDiary.service;

import com.beatex.climbingDiary.dtos.RoutDto;
import com.beatex.climbingDiary.model.Rate;
import com.beatex.climbingDiary.model.Region;
import com.beatex.climbingDiary.model.Rout;
import com.beatex.climbingDiary.repository.ClimberRepository;
import com.beatex.climbingDiary.repository.RoutRepository;
import com.beatex.climbingDiary.utils.RoutMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoutService {

    private final RoutRepository routRepository;
    private final RoutMapper routMapper;


    public RoutService(RoutRepository routRepository, RoutMapper routMapper) {
        this.routRepository = routRepository;
        this.routMapper = routMapper;
    }

    public List<Rout> allRouts(){
        return routRepository.findAll();
    }

    public List<Rout> getRoutsByRegion(Region region){
        return routRepository.findRoutByRegion(region);
    }

    public Rate getRateByRoutName(String routName){
        return routRepository.getRateByName(routName);
    }

    public void addRout(RoutDto routDto){
        routRepository.save(routMapper.fromRoutDto(routDto));
    }

    @Transactional
    public void deleteRoutByName(String name){
        routRepository.deleteRoutByName(name);
    }
}
