package com.cubingmty.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	@GetMapping("/admin")
	public String tourneyPage() {
		return "admin";
	}
	
}
