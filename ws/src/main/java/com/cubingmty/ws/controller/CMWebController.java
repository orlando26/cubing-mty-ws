package com.cubingmty.ws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CMWebController {
	
	@GetMapping("/")
	public String hello() {
		return "Todavia no hay nada pero aqui estara la pag del team :3";
	}
	
}
