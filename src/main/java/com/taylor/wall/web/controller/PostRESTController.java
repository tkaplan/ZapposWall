package com.taylor.wall.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taylor.wall.web.domain.Post;

@Controller
public class PostRESTController {
	// Crud operations
	
	// Create Post
	@RequestMapping(value = "/post/create/", method = RequestMethod.POST)
	public String createPost(@ModelAttribute Post post, Model model) {
		// Check to see is our user is logged in
		
		// Check to see if our user is verified
		
		// Create a new post, create user post wall associations
		
		// Return a 200
		return "";
	}
	
	// Read Post
	
	// Update Post
	
	// Delete Post
}
