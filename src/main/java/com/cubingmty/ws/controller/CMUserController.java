package com.cubingmty.ws.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cubingmty.ws.entity.CMUser;
import com.cubingmty.ws.entity.StandardResponse;
import com.cubingmty.ws.jwt.JwtTokenProvider;
import com.cubingmty.ws.service.CMUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/user")
@Api(tags = "User API", value = "UserApi", description = "user controller api")
public class CMUserController {

	@Autowired
	private CMUserService userService;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@CrossOrigin
	@PostMapping("/registration")
	@ApiOperation(value = "Creates a user")
	public StandardResponse<CMUser> save(@RequestBody CMUser user){
		return userService.save(user);
	}

	@CrossOrigin
	@PostMapping("/saveTestUser")
	@ApiOperation(value = "Creates a user for testing purposes")
	public StandardResponse<CMUser> saveTestUser(@RequestParam String name, @RequestParam String password, @RequestParam String wcaid){
		return userService.registerTestUser(name, password, wcaid);
	}

	@GetMapping("/login")
	public ResponseEntity<?> getUser(Principal principal){

		if(principal == null){
			//logout will also use here so we should return ok http status.
			return ResponseEntity.ok(principal);
		} 
		UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
		CMUser user = userService.findByEmail(authenticationToken.getName()); 
		 
		user.setToken(tokenProvider.generateToken(authenticationToken)); 

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping
	@ApiOperation(value = "List all users")
	public List<CMUser> findAll(){
		return userService.findAll();
	}

	@CrossOrigin
	@GetMapping("/{id}")
	@ApiOperation(value = "find a user by its Id")
	public CMUser findById(@PathVariable("id") Integer id){
		return userService.findById(id).get();
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	@ApiOperation(value = "delete a user by its Id")
	public void delete(@PathVariable("id") Integer id) {
		userService.delete(id);
	}



}
