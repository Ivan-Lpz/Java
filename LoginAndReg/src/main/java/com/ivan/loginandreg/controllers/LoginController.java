package com.ivan.loginandreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ivan.loginandreg.models.LoginUser;
import com.ivan.loginandreg.models.User;
import com.ivan.loginandreg.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String index(Model model) {
		
		//Bing empty User and LoginUser objects to the JSP
		//to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        userServ.register(newUser, result);
        
        // No errors! 
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        } else {
        	// TO-DO Later: Store their ID from the DB in session, 
        	// in other words, log them in.
        	session.setAttribute("user_id", newUser.getId());
        	return "redirect:/success";
        	
        }
        
    
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
         User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        } else {
        	session.setAttribute("user_id", user.getId());
        	return "redirect:/success";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
    
    }
    
    @GetMapping("/success")
    public String success(HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	//CHECK IF USER IS IN SESSION
    	if (userId == null) {
    		return "redirect:/";
    	} else {
    		
    		User thisUser = userServ.findOne(userId);
    		model.addAttribute("thisUser", thisUser);
    		return "success.jsp";
    	}
    }
    
   // === LOGOUT route ===
    		@GetMapping("/logout")
    		public String logout(HttpSession s) {
    			s.invalidate();
    			return "redirect:/";
    		}

}
