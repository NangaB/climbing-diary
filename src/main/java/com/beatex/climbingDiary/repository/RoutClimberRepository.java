package com.beatex.climbingDiary.repository;

import com.beatex.climbingDiary.model.Rate;
import com.beatex.climbingDiary.model.RoutClimber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutClimberRepository extends JpaRepository<RoutClimber, Long> {

//    @Query(value = "select r.rate from RoutClimber r where r.id = :climberId ")
//    Rate getRateByClimberId(Long climberId);
}
