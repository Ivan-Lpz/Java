package com.ivan.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ivan.fruityloops.models.Item;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String other(Model model) {
//		model.addAttribute("bob", 44);
		// Add fruits your view model here
		
		ArrayList<Item> fruits = new ArrayList<Item>();
		fruits.add(new Item("Kiwi", 1.5));
		fruits.add(new Item("Mango", 2.0));
		fruits.add(new Item("Goji Berries", 4.0));
		fruits.add(new Item("Guava", .75));
		
		// Add to view model
		model.addAttribute("arrayFruits", fruits);
		return "index.jsp";
	}
	
	
	
	@RequestMapping("/others")
	public String index(Model model) {
		String firstName = "Bob";
		String lastName = "Bobberson";
		String email = "Bob@mail.com";
		Integer age = 40;
		model.addAttribute("first", firstName);
		model.addAttribute("last", lastName);
		model.addAttribute("email", email);
		model.addAttribute("age", age);

		
		return "other.jsp";
	}
}
	
	
	
	
	
	
	

