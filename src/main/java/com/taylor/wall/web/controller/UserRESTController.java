package com.taylor.wall.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taylor.wall.persistence.repository.UserRepository;
import com.taylor.wall.web.domain.User;

@Controller
public class UserRESTController {
	@Autowired
	UserRepository userRepository;

	@Autowired(required=true)
	private HttpServletRequest request;
	
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
		
		HttpSession session = request.getSession();
		session.setAttribute("ROLE", "USER");
		session.setAttribute("USER_ID", user.getId());
		
		return "/home/";
	}
	
	// Read User
	
	// Update User
	
	// Delete User
}
