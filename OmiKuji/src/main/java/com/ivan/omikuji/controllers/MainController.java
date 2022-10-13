package com.ivan.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping("/omikuji")
	public String formPage(Model model) {
		int[] arrayNum = {5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		model.addAttribute("arrayNum", arrayNum);
		return"index.jsp";
	}
	
	
	
	@RequestMapping(value="/submitpost", method=RequestMethod.POST)
	public String submitpost(@RequestParam("num") Integer num,
							 @RequestParam("city") String city,
							 @RequestParam("person") String person,
							 @RequestParam("hobby") String hobby,
							 @RequestParam("thing") String thing,
							 @RequestParam("comment") String comment,
							 HttpSession session) {
		System.out.println(num + city + person + hobby + thing + comment);
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("comment", comment);
		return "redirect:/omikuji/show";
	}


	
	
	
	@RequestMapping("/omikuji/show")
	public String show() {
		
		return "show.jsp";
	}

}
