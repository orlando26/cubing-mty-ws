package com.cubingmty.ws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cubingmty.ws.entity.CMUser;

public interface CMUserRepository extends JpaRepository<CMUser, Integer> {
	
	public Optional<CMUser> findByEmail(String email);
	
}
