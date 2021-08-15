package com.beatex.climbingDiary.repository;

import com.beatex.climbingDiary.model.Rate;
import com.beatex.climbingDiary.model.Region;
import com.beatex.climbingDiary.model.Rout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutRepository extends JpaRepository<Rout, Long> {

    List<Rout> findRoutByRegion(Region region);

    @Query(value = "select rate from Rout where name =:routName")
    Rate getRateByName(String routName);

}
