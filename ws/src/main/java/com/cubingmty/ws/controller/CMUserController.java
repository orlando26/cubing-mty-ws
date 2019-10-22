package com.cubingmty.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubingmty.ws.entity.CMUser;
import com.cubingmty.ws.entity.StandardResponse;
import com.cubingmty.ws.service.CMUserService;

@RestController
@RequestMapping("/api/v1/user")
public class CMUserController {
	
	@Autowired
	private CMUserService userService;
	
	@CrossOrigin
	@PostMapping
	public StandardResponse<CMUser> save(@RequestBody CMUser user){
		System.out.println(user);
		return userService.save(user);
	}
	
	@CrossOrigin
	@GetMapping
	public List<CMUser> findAll(){
		return userService.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public CMUser findById(@PathVariable("id") Integer id){
		return userService.findById(id).get();
	}
	
	
	
}
