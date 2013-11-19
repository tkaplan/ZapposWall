package com.taylor.wall.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taylor.wall.persistence.repository.UserRepository;
import com.taylor.wall.web.domain.*;

@Controller
public class SecurityController {

	@Autowired
	UserRepository userRepository;
	
	// Login User
	@RequestMapping(value="/security/login/", method=RequestMethod.POST )
	public String login(@ModelAttribute User) {
		
	}
	
	@RequestMapping(value="/security/logout/", method=RequestMethod.GET )
	public String logout() {
		// Remove session attribute
	}
}
