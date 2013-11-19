package com.taylor.wall.core.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Wall {
	
	private Long id;
	// This needs to be synchronized and concurrent
	private List<Post> posts;
	
	public Wall() {
		posts = new LinkedList<Post>();
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public synchronized void addPost(Post post) {
		posts.add(post);
	}
	
	// I'm worried about reading from the posts
	// while addPost writes at the same time;
	public synchronized List<Post> getPost() {	
		return Collections.unmodifiableList(posts);
	}
}
