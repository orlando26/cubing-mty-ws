package com.cubingmty.ws.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cubingmty.ws.entity.CMSolves;

public interface CMSolvesRepository extends JpaRepository<CMSolves, Integer>{
	
	public List<CMSolves> findByUserId(Integer userId);
	
	public List<CMSolves> findByCube(String cube);
	
	public List<CMSolves> findByUserIdAndCube(Integer userId, String cube);
	
	public List<CMSolves> findAllByOrderByTimeAsc();
	
	public List<CMSolves> findByCubeOrderByTimeAsc(String cube);
	
	public List<CMSolves> findByCubeOrderByDateAsc(String cube);
	
	public CMSolves findTopByUserIdAndCubeOrderByTimeAsc(Integer userId, String cube);
	
	public List<CMSolves> findByUserIdAndCubeOrderByTimeAsc(Integer userId, String cube);
	
	public List<CMSolves> findByUserIdAndCubeOrderByDateAsc(Integer userId, String cube);

}
