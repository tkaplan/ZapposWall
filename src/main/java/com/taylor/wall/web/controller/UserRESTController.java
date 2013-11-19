package com.taylor.wall.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taylor.wall.persistence.repository.UserRepository;
import com.taylor.wall.web.domain.User;
import com.taylor.wall.persistence.domain.User as UserPersist;

@Controller
public class UserRESTController {
	// CRUD Operations
	@Autowired
	UserRepository userRepository;
	
	// Create User
	@RequestMapping(value="/user/create/", method=RequestMethod.POST )
	public String createUser(@ModelAttribute User user, Model model) {
	
		com.taylor.wall.persistence.domain.User userPersist = new com.taylor.wall.persistence.domain.User();
		
		if(user.getEmail().isEmpty() || user.getEmail() == null) {
			return "/signup/error/"; 
		}
		
		if(user.getUsername().isEmpty() || user.getUsername() == null) {
			return "/signup/error/";
		}
		
		userPersist.setEmail(user.getEmail());
		userPersist.setUsername(user.getUsername());
		
		//Persist
		userRepository.save(userPersist);
		
		return "/home/";
	}
	
	// Read User
	
	// Update User
	
	// Delete User
}
