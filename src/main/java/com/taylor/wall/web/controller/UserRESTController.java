package com.taylor.wall.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taylor.wall.web.domain.User;

@Controller
public class UserRESTController {
	// CRUD Operations
	
	// Create User
	@RequestMapping(value="/user/create/", method=RequestMethod.POST )
	public String createUser(@ModelAttribute User user, Model model) {
		// Validate Information
		
		// Persist
		
		return "";
	}
	
	// Read User
	
	// Update User
	
	// Delete User
}
