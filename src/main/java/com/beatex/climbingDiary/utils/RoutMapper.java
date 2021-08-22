package com.beatex.climbingDiary.utils;

import com.beatex.climbingDiary.dtos.RoutDto;
import com.beatex.climbingDiary.model.Rout;
import org.springframework.stereotype.Component;

@Component
public class RoutMapper {

    public Rout fromRoutDto (RoutDto routDto){

        return new Rout.Builder()
                .name(routDto.getName())
                .region(routDto.getRegion())
                .rateName(routDto.getRateName())
                .build();

    }

    public RoutDto fromRout (Rout rout){
        return new RoutDto.Builder()
                .name(rout.getName())
                .region(rout.getRegion())
                .rateName(rout.getRate().getRateName())
                .build();
    }


}
