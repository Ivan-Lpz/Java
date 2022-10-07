package com.ivan.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MainController {
	
	@RequestMapping ("/")
	public String human() {
		return "Hello Human";
	}
	
	@RequestMapping ("/human")
	public String human(@RequestParam(value="q") String name) {
		return "Hello " + name;
	}
	
	

}
