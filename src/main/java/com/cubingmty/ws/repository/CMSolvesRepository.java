package com.cubingmty.ws.repository;

import java.util.List;

import com.cubingmty.ws.entity.CMSolves;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CMSolvesRepository extends JpaRepository<CMSolves, Integer>{
	
	public List<CMSolves> findByUserId(Integer userId);
	
	public List<CMSolves> findByCube(String cube);
	
	public List<CMSolves> findByUserIdAndCubeOrderByTimeAsc(Integer userId, String cube);

	public List<CMSolves> findByUserIdAndCubeOrderByDateAsc(Integer userId, String cube);
	
	public List<CMSolves> findAllByOrderByTimeAsc();
	
	public List<CMSolves> findByCubeOrderByTimeAsc(String cube);
	
	public List<CMSolves> findByCubeOrderByDateAsc(String cube);
	
	@Query(value = "select * from cm_solves where id in (:idsList) order by Time ", nativeQuery = true) 
	public List<CMSolves> findAllByTourneyId(@Param("idsList") List<Integer> idsList);

	@Query(value = "select * from cm_solves where cube = :cube and id in (:idsList) order by Time ", nativeQuery = true) 
	public List<CMSolves> findByCubeAndTourneyId(@Param("cube") String cube ,@Param("idsList") List<Integer> idsList);
 
} 
