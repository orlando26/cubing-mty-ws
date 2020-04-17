package com.cubingmty.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubingmty.ws.entity.Scramble;
import com.cubingmty.ws.scramblers.ScramblerProvider;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/scramble")
@Api(tags = "Scramble API", value = "ScrambleApi", description = "scramble controller api")
public class CMScrambleController {
	
	@Autowired
	private ScramblerProvider scramblerProvider;
	
	@GetMapping("/{cube}")
	@CrossOrigin
	@ApiOperation(value = "Retrieves a sramble for a given cube.", nickname = "Get Scramble")
	public Scramble getScramble(@PathVariable(name = "cube") String cube) {
		return scramblerProvider.getScramble(cube);
	}
	
}
