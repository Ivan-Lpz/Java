package com.ivan.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ivan.bookclub.models.LoginUser;
import com.ivan.bookclub.models.User;
import com.ivan.bookclub.repos.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO: Additional validations!
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "registerError", "this email is taken");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "registerError", "passwords must match");
    	}
    	
    	//return the errors back
    	if(result.hasErrors()) {
    		return null;
    	} else {
    		//hash the password
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
    		//SAVE USER TO DATABASE
    		return userRepo.save(newUser);
    	}
    }
    
    //--LOGIN--
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	if (!potentialUser.isPresent()) {
    		result.rejectValue("email", "loginError", "email not in database");
    	} else {
    		User user = potentialUser.get();
    		//BCRYPT check password
    		System.out.println(user.getPassword());
    		System.out.println(newLoginObject.getPassword());

    		if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    			result.rejectValue("password", "loginError", "invalid password");
    		}
    		
    		if(result.hasErrors()) {
    			return null;
    		} else {
    			return user;
    		}
    		
    	}
        return null;
    }
    
    
    //READ ONE
    public User findOne(Long id) {
    	
    	Optional<User> optionalUser = userRepo.findById(id);
    	
    	if(optionalUser.isPresent()) {
    		return optionalUser.get();
    	} else {
    		return null;
    	}
    	
    }
    
    
    
    //READ ALL----MOSTLY WILL BE USED FOR ADMIN 
    public List<User> allUsers() {
    	return userRepo.findAll();
    }
}

