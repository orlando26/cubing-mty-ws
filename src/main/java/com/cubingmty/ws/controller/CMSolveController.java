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
	public StandardResponse<CMSolves> saveTestSolve(@RequestParam Integer userId, @RequestParam Integer time, @RequestParam String cube){
		return solveService.registerTestSolve(userId, time, cube);
	}

	@CrossOrigin
	@GetMapping
	@ApiOperation(value = "List all solves")
	public List<CMSolves> findAll(){
		return solveService.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/byTime")
	@ApiOperation(value = "List solves by time")
	public List<CMSolves> findByOrderByTime(){
		return solveService.findAllByOrderByTime();
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
	@GetMapping("/byUser/{userId}")
	@ApiOperation(value = "List solves by user")
	public List<CMSolves> getSolveByUser(@PathVariable("userId") Integer userId){
		return solveService.getSolveByUser(userId);
	}
	
	@CrossOrigin
	@GetMapping("/byCube/{cube}")
	@ApiOperation(value = "List solves by cube")
	public List<CMSolves> getSolveByCube(@PathVariable("cube") String cube){
		return solveService.getSolveByCube(cube);
	}
	
	
	@CrossOrigin
	@GetMapping("/byUserAndCube/{userId},{cube}")
	@ApiOperation(value = "List solves by user and cube")
	public List<CMSolves> getSolveByUserAndCube(@PathVariable("userId") Integer userId, @PathVariable("cube") String cube){
		return solveService.getSolveByUserAndCube(userId, cube);
	}
	
	@CrossOrigin
	@GetMapping("/bestbyUserAndCube/{userId},{cube}")
	@ApiOperation(value = "Find best solve by user and cube")
	public List<CMSolves> getBestSolveByUserAndCube(@PathVariable("userId") Integer userId, @PathVariable("cube") String cube){
		return solveService.getBestSolveByUserAndCube(userId, cube);
	}
	
	
	@CrossOrigin
	@GetMapping("ByCubeOrderByTime/{cube}")
	@ApiOperation(value = "List solves by cube sorted by time")
	public List<CMSolves> getByCubeOrderByTime(String cube){
		return solveService.getByCubeOrderByTime(cube);
	}
	
	
	@CrossOrigin
	@GetMapping("ByCubeOrderByDate/{cube}")
	@ApiOperation(value = "List solves by cube sorted by date")
	public List<CMSolves> getByCubeOrderByDate(String cube){
		return solveService.getByCubeOrderByDate(cube);
	}
	
	
	@CrossOrigin
	@GetMapping("ByUserIdAndCubeOrderByTime/{userId},{cube}")
	@ApiOperation(value = "List solves by user and cube sorted by time")
	public List<CMSolves> getByUserIdAndCubeOrderByTime(@PathVariable("userId") Integer userId, @PathVariable("cube") String cube){
		return solveService.getByUserIdAndCubeOrderByTime(userId, cube);
	}
	
	
	@CrossOrigin
	@GetMapping("ByUserIdAndCubeOrderByDate/{userId},{cube}")
	@ApiOperation(value = "List solves by user and cube sorted by date")
	public List<CMSolves> getByUserIdAndCubeOrderByDate(@PathVariable("userId") Integer userId, @PathVariable("cube") String cube){
		return solveService.getByUserIdAndCubeOrderByDate(userId, cube);
	}
	
	



}
