package com.cubingmty.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubingmty.ws.entity.catalogs.CMRole;
import com.cubingmty.ws.repository.CMRoleRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/catalog/roles")
@Api(tags = "Roles Catalog API", value = "RoleCatalog", description = "role catalog documentation")
public class CMRoleController {
	
	@Autowired
	private CMRoleRepository roleRepository;
	
	@GetMapping
	@CrossOrigin
	public List<CMRole> getAllRoles(){
		return roleRepository.findAll();
	}
	
}
