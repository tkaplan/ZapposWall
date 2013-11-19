package com.taylor.wall.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taylor.wall.persistence.repository.PostRepository;
import com.taylor.wall.persistence.repository.UserRepository;
import com.taylor.wall.web.domain.Post;

@Controller
public class PostRESTController {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired(required=true)
	private HttpServletRequest request;
	// Crud operations
	
	// Create Post
	@RequestMapping(value = "/post/create/", method = RequestMethod.POST)
	public String createPost(@ModelAttribute Post post, Model model) {
		// Get our session
		HttpSession session = request.getSession();
		if(session.getAttribute("ROLE") != "USER") {
			// If we are not signed in, then just return
			return "/";
		}
		
		Long id = (Long) session.getAttribute("USER_ID");
		com.taylor.wall.persistence.domain.User user = userRepository.findOne(id);
		// Create a new post
		com.taylor.wall.persistence.domain.Post postPersistence = new com.taylor.wall.persistence.domain.Post();
		postPersistence.setBody(post.getBody());
		postPersistence.setUser(user);
		user.addPost(postPersistence);
		// Save to our database
		postRepository.save(postPersistence);
		userRepository.save(user);
		// Return a 200
		return "/home/";
	}
	
	// Read All Post
	
	// Update Post
	
	// Delete Post
}
