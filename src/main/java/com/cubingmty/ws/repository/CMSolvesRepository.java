package com.cubingmty.ws.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cubingmty.ws.entity.CMSolves;

public interface CMSolvesRepository extends JpaRepository<CMSolves, Integer>{
	
	public List<CMSolves> findByUserId(Integer userId);

}