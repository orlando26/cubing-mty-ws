package com.cubingmty.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cubingmty.ws.entity.CMUser;

public interface CMUserRepository extends JpaRepository<CMUser, Integer> {

}
