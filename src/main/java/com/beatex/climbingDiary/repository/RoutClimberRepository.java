package com.beatex.climbingDiary.repository;

import com.beatex.climbingDiary.model.RoutClimber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutClimberRepository extends JpaRepository<RoutClimber, Long> {

    RoutClimber findRoutClimberByName(String routName);

    RoutClimber findRoutClimberById(Long id);

    @Modifying
    int deleteRoutClimberById(Long id);

}
