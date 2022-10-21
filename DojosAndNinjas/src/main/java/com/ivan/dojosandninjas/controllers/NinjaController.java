package com.ivan.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ivan.dojosandninjas.models.Dojo;
import com.ivan.dojosandninjas.models.Ninja;
import com.ivan.dojosandninjas.services.DojoService;
import com.ivan.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {

	@Autowired
	private NinjaService ninjaServ;
	@Autowired
	private DojoService dojoServ;
	

	@GetMapping("/ninjas/new") // This will display main page with all expenses and the form
	public String index(@ModelAttribute("dojo") Dojo dojo, Model model) { // Model model allows us to display in the jsp
		// get the expenses
		List<Ninja> allninjas = ninjaServ.allNinjas();// creates an object which is a list object
		// pass the expenses to the jsp
		model.addAttribute("allNinjas", allninjas); // this will allow us to display to our jsp
		// create new expense
		Ninja newNinja = new Ninja(); // this will allows to create an new expense and the right side of the equal
											// sign comes from the empty constructor in the model
		
		model.addAttribute("newNinja", newNinja);
		List<Dojo> allDojos = dojoServ.allDojos();
		model.addAttribute("allDojos", allDojos);
		
		return "newninja.jsp";
	}
	
	
	
	//POST METHOD CREATE NINJA
		@PostMapping("/ninjas/submit")
		public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
			
			if(result.hasErrors()) {
				List<Ninja> allNinjas = ninjaServ.allNinjas();
				model.addAttribute("allDojos", allNinjas);
				return "index.jsp";
			} else {
				ninjaServ.createNinja(ninja);
				return "redirect:/dojos/all";
			}

}
		
		@GetMapping("/all/ninjas")
		public String viewAllNinjas(Model model) {
			List<Ninja> allNinjas = ninjaServ.allNinjas();
			model.addAttribute("allNinjas", allNinjas);
			
			return "everyninja.jsp";
		}
		

}