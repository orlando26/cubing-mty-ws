package com.cubingmty.ws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cubingmty.ws.entity.CMTimes;

public interface CMTimesRepository extends JpaRepository<CMTimes, Integer>{
	
	public Optional<CMTimes> findByUserId(Integer userId);

}
