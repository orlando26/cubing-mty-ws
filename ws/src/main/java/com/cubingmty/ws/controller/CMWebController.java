package com.cubingmty.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CMWebController {
	
	@GetMapping("/")
	public String hello() {
		return "home";
	}
	
	@GetMapping("/signup")
	public String registerPage() {
		return "register";
	}
	
}
