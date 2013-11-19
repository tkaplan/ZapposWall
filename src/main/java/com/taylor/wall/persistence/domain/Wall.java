package com.taylor.wall.persistence.domain;

import javax.persistence.*;

import java.util.Collections;
import java.util.List;

@Entity(name="WALL")
public class Wall {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// This needs to be synchronized and concurrent
	@OneToMany(fetch = FetchType.LAZY)
	private List<Post> posts;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public synchronized void setPost(Post post) {
		posts.add(post);
	}
	
	// I'm worried about reading from the posts
	// while addPost writes at the same time;
	public synchronized List<Post> getPost() {	
		return Collections.unmodifiableList(posts);
	}
}
