package com.taylor.wall.web.domain;

import java.util.Date;
import java.util.List;

public class User {
	private Long id;
	private List<Post> posts;
	private Date created;
	private String email;
	private String username;
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setDate(Date created) {
		this.created = created;
	}
	public Date getDate() {
		return created;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
}
