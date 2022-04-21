package com.g3.projectwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
	
	@GetMapping("/test")
	
	@ResponseBody
	public String test() {
		return "Benvenuto sul sito";
	}

	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	

}
