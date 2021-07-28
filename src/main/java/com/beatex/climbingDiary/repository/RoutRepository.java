package com.beatex.climbingDiary.repository;

import com.beatex.climbingDiary.model.Rout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutRepository extends JpaRepository<Rout, Long> {

}
