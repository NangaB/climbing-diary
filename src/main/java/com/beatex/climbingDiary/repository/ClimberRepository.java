package com.beatex.climbingDiary.repository;

import com.beatex.climbingDiary.model.Climber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimberRepository extends JpaRepository<Climber, Long> {
}
