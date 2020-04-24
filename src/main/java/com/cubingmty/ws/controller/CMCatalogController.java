package com.cubingmty.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubingmty.ws.entity.catalogs.CMCity;
import com.cubingmty.ws.entity.catalogs.CMRole;
import com.cubingmty.ws.entity.catalogs.CMState;
import com.cubingmty.ws.repository.CMCityRepository;
import com.cubingmty.ws.repository.CMRoleRepository;
import com.cubingmty.ws.repository.CMStateRepository;
import com.cubingmty.ws.service.CMCubeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/catalog")
@Api(tags = "Catalog API", value = "Catalog", description = "catalogs documentation")
public class CMCatalogController {
	
	@Autowired
	private CMCubeService cubeService;
	
	@Autowired
	private CMRoleRepository roleRepository;

	@Autowired
	private CMStateRepository stateRepository;

	@Autowired
	private CMCityRepository cityRepository;
	
	@GetMapping("/roles")
	@CrossOrigin
	public List<CMRole> getAllRoles(){
		return roleRepository.findAll();
	}

	@GetMapping("/states")
	@CrossOrigin
	public List<CMState> getAllStates(){
		return stateRepository.findAll();
	}

	@GetMapping("/citiesByState/{stateId}")
	@CrossOrigin
	public List<CMCity> getAllcities(@PathVariable(name = "stateId") Integer stateId){
		return cityRepository.findByStateId(stateId);
	}
	
	@GetMapping("/cubes")
	@CrossOrigin
	public List<String> getCubes(){
		return cubeService.getCubesList();
	}
	
}
