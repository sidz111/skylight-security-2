package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	@GetMapping("/")
	public String homepage() {
		return "index";
	}
	
	@GetMapping("/user")
	public String userpage() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String adminpage() {
		return "admin";
	}
}
