package com.cubingmty.ws.controller;

import java.util.List;

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

import com.cubingmty.ws.entity.CMTimes;
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
	public StandardResponse<CMTimes> save(@Valid @RequestBody CMTimes solve){
		return solveService.save(solve);
	}

	
	@CrossOrigin
	@PostMapping("/saveSolveUser")
	public StandardResponse<CMTimes> saveTestSolve(@RequestParam Double time){
		return solveService.registerTestSolve(time);
	}


	//@CrossOrigin
	//@GetMapping
	//@ApiOperation(value = "List all solves")
	//public List<CMTimes> findAll(){
	//	return solveService.findAll();
	//}
	
	@CrossOrigin
	@GetMapping
	@ApiOperation(value = "List all solves sorted")
	public List<CMTimes> findAllSorted(){
		return solveService.findAllSorted();
	}

	@CrossOrigin
	@GetMapping("/{id}")
	@ApiOperation(value = "find a time by its Id")
	public CMTimes findById(@PathVariable("id") Integer id){
		return solveService.findById(id).get();
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	@ApiOperation(value = "delete a solve by its Id")
	public void delete(@PathVariable("id") Integer id) {
		solveService.delete(id);
	}



}
