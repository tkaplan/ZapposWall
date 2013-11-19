package com.taylor.wall.web.domain;

import java.util.Date;

import com.taylor.wall.web.domain.User;

public class Post {
	
	private Long id;
	private User user;
	private Date created;
	private String body;
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getCreated() {
		return created;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getBody() {
		return body;
	}
}
