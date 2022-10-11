package com.ivan.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		return "index.jsp";

	}

	@RequestMapping("/counter")
	public String counter(HttpSession session) {

		if (session.getAttribute("counter") == null) {
			session.setAttribute("counter", 0);
		} else {
			Integer count = (Integer) session.getAttribute("counter");
			session.setAttribute("counter", count + 1);
		}
		return "counter.jsp";
	}

	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		session.invalidate();
		return "counter.jsp";
	}
}
