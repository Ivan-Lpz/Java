package com.ivan.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ivan.dojosandninjas.models.Dojo;
import com.ivan.dojosandninjas.services.DojoService;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoServ;
	
	
	@GetMapping("/dojos/new")
	public String dojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> allDojos = dojoServ.allDojos();
		model.addAttribute("allDojos", allDojos);
		
		return "index.jsp";
	}
	
	
	//POST METHOD CREATE DOJO
	@PostMapping("/dojos/submit")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			List<Dojo> allDojos = dojoServ.allDojos();
			model.addAttribute("allDojos", allDojos);
			return "index.jsp";
		} else {
			dojoServ.createDojo(dojo);
			return "redirect:/dojos/all";
		}
		
		
	}
	
	@GetMapping("/dojos/all")
	public String alldojos(Model model) {
		List<Dojo> allDojos = dojoServ.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "alldojos.jsp";
	}
	
	@GetMapping("/allninjas/{id}")
	public String allninjas(@PathVariable("id")Long id, Model model) {
		Dojo dojo = dojoServ.findDojo(id);
		model.addAttribute("dojo", dojo);
		
		
		return "allninjas.jsp";
	}
	
	
	

}
