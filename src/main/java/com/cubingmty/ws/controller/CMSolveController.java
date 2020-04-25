package com.cubingmty.ws.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.cubingmty.ws.entity.CMSolves;
import com.cubingmty.ws.entity.StandardResponse;
import com.cubingmty.ws.service.CMSolveService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/solve")
@Api(tags = "Solve API", value = "SolveApi", description = "solve controller api")
public class CMSolveController {

	@Autowired
	private CMSolveService solveService;
	
	
	@CrossOrigin
	@PostMapping("/saveSolve")
	public StandardResponse<CMSolves> save(@Valid @RequestBody CMSolves solve){
		return solveService.save(solve);
	}

	
	@CrossOrigin
	@PostMapping("/saveSolveUser")
	public StandardResponse<CMSolves> saveTestSolve(@RequestParam Integer userId, @RequestParam Integer time){
		return solveService.registerTestSolve(userId, time);
	}

	@CrossOrigin
	@GetMapping
	@ApiOperation(value = "List all solves")
	public List<CMSolves> findAll(){
		return solveService.findAll();
	}
	
	
	@CrossOrigin
	@GetMapping("/{id}")
	@ApiOperation(value = "Find a time by its Id")
	public CMSolves findById(@PathVariable("id") Integer id){
		return solveService.findById(id).get();
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a solve by its Id")
	public void delete(@PathVariable("id") Integer id) {
		solveService.delete(id);
	}
	
	
	@CrossOrigin
	@GetMapping("/userId")
	@ApiOperation(value = "Find a solve by user")
	public List<CMSolves> getSolveByUser(@PathVariable("userId") Integer userId){
		return solveService.getSolveByUser(userId);
	}



}
