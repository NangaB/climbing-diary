package com.beatex.climbingDiary.repository;

import com.beatex.climbingDiary.model.Climber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ClimberRepository extends JpaRepository<Climber, Long> {

    @Query(value = "select c from Climber c where c.id = :id" )
    Climber getClimberById(Long id);

    @Query(value = "select c from Climber c where c.name = :name" )
    Climber getClimberByName(String name);

    @Query(value = "select c.id from Climber c where c.name =:name")
    Long getClimberIdByName(String name);

    @Query(value = "select c from Climber c order by points desc")
    List<Climber> getAllClimbersSorted();

}
