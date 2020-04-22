package com.cubingmty.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubingmty.ws.entity.catalogs.CMRole;
import com.cubingmty.ws.repository.CMRoleRepository;
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
	
	@GetMapping("/roles")
	@CrossOrigin
	public List<CMRole> getAllRoles(){
		return roleRepository.findAll();
	}
	
	@GetMapping("/cubes")
	@CrossOrigin
	public List<String> getCubes(){
		return cubeService.getCubesList();
	}
	
}
