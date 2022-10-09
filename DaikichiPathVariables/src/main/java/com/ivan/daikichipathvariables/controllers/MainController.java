package com.ivan.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping("/daikichi")
	public String index() {
		return "Welcome!";
	}
	
	@RequestMapping("/daikichi/today")
	public String luck() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("/daikichi/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping ("/daikichi/travel/{var1}")
	public String travel(@PathVariable("var1") String var1) {
		return "Congratulations! You will soon traval to " + var1 + "!";
	}
	
	@RequestMapping ("/daikichi/lotto/{num1}")
	public String lotto(@PathVariable("num1") int num1) {
		if (num1  % 2 == 0) {
		return "You will take a grand journey in the near future, but be weary of tempting offers";
		
		} else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	

}
	
}
