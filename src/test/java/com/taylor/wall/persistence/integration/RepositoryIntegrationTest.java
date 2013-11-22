package com.taylor.wall.persistence.integration;

import com.taylor.wall.config.JPAConfiguration;
import com.taylor.wall.persistence.domain.*;
import com.taylor.wall.persistence.repository.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class RepositoryIntegrationTest {

  @Autowired
  UserRepository userRepository;
  
  @Autowired
  PostRepository postRepository;

  @Test
  public void createUser() throws Exception {

    User user = new User();
    user.setPassword("Hello");
    user.setEmail("taylor@yahoo.com");
    
    userRepository.save(user);
    User user2 = userRepository.findByEmail("taylor@yahoo.com");
    
    // This shows that I can save and retrieve users from a database
    assertNotNull(user2);
    assertEquals("taylor@yahoo.com",user2.getEmail());
    
    // This proves I can build my own little authentication system
    assertTrue(user2.checkPassword("Hello"));
  }
  
  @Test
  public void createPost() throws Exception {
	
	String testBody = "This is only my 4th day with Spring 3 MVC and java"
    		+ "servlet stuff."
    		+ "Though this is a bit more difficult than "
    		+ "PHP, it's extremely rewarding and a bit more fun."
    		+ "I'm hoping you guy's find"
    		+ "this project cool enough to give me an interview,"
    		+ "cause I worked my but off to get this to work:)";
	  
	User user = new User();
	user.setEmail("Hello@yahoo.com");
	user.setUsername("HelloDude");
	
    Post post = new Post();
    post.setBody(testBody);
    assertNotNull(post);
    post.setUser(user);
        
    // Add post
    user.addPost(post);
    
    userRepository.save(user);
    postRepository.save(post);
    
    Iterable<User> users = userRepository.findAll();
    List<Post> posts = null;
    
    // Get our posts
    for(User userI : users) {
    	if(!userI.getPosts().isEmpty()) {
    		posts = userI.getPosts();
    	}
    }
    
    // Find our post and make sure we have the right one
    assertNotNull(posts);
    for(Post postI : posts) {
    	assertEquals(postI.getBody(),testBody);
    }
  }

}
