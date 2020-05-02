package com.cubingmty.ws.repository;

import java.util.List;

import com.cubingmty.ws.entity.CMSolveTourney;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CMSolveTourneyRepository extends JpaRepository<CMSolveTourney, Integer>{

    @Query(value = "select Id_Solve from cm_solve_tourney where Id_Tourney = :tourneyId ", nativeQuery = true)
    public List<Integer> getSolvesIdsBytourneyId(@Param("tourneyId") Integer id); 

}