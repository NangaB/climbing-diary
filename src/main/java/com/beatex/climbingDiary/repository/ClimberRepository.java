package com.beatex.climbingDiary.repository;

import com.beatex.climbingDiary.model.Climber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimberRepository extends JpaRepository<Climber, Long> {

    @Query(value = "select c from Climber c where c.id = :id" )
    Climber getClimberById(Long id);

    @Query(value = "select c from Climber c where c.name = :name" )
    Climber getClimberByName(String name);

}
