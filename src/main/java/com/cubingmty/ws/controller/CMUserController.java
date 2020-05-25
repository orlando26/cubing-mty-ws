package com.cubingmty.ws.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cubingmty.ws.entity.AuthRequest;
import com.cubingmty.ws.entity.CMUser;
import com.cubingmty.ws.entity.StandardResponse;
import com.cubingmty.ws.service.CMUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/user")
@Api(tags = "User API", value = "UserApi", description = "user controller api")
public class CMUserController {

	@Autowired
	private CMUserService userService;



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

	@CrossOrigin
	@PostMapping("/authenticate") 
	@ApiOperation(value = "Authenticate user")
	public StandardResponse<CMUser> authenticate(@RequestBody AuthRequest auth){
		return userService.authenticate(auth);
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

	@CrossOrigin
	@PostMapping("/uploadImg/{id}")
	public boolean pictureupload(@PathVariable(name = "id") Integer id, @RequestParam("image") MultipartFile file) {
		return userService.pictureupload(id, file);

	}
}
