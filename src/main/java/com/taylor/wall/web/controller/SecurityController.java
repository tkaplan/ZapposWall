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
import com.taylor.wall.web.domain.*;

@Controller
public class SecurityController {

	@Autowired
	UserRepository userRepository;

	@Autowired(required=true)
	private HttpServletRequest request;
	
	// Login User
	@RequestMapping(value="/security/login/", method=RequestMethod.POST )
	public String login(@ModelAttribute User user, Model model) {
		HttpSession session = request.getSession();
		com.taylor.wall.persistence.domain.User userPersistence = userRepository.findByEmail(user.getEmail());
		
		// If user provided correct password
		if(userPersistence.checkPassword(user.getPassword())) {
			session.setAttribute("USER_ID",userPersistence.getId());
			session.setAttribute("ROLE","USER");
		}
		return "/";
	}

	// Login User
	@RequestMapping(value="/security/login/", method=RequestMethod.GET )
	public String login(@ModelAttribute User user, Model model) {
		return "/login/";
	}
	
	@RequestMapping(value="/security/logout/", method=RequestMethod.GET )
	public String logout() {
		// Remove session attribute
		HttpSession session = request.getSession();
		session.setAttribute("ROLE", "ANON");
		return "/home/";
	}
}
