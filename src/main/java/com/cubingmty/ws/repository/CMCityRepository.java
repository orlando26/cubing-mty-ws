package com.cubingmty.ws.repository;

import java.util.List;

import com.cubingmty.ws.entity.catalogs.CMCity;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CMCityRepository extends JpaRepository<CMCity, Integer>{

    public List<CMCity> findByStateId(Integer id);

}