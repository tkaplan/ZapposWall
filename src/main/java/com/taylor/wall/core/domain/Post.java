package com.taylor.wall.core.domain;

import java.util.Date;

public class Post {
	
	private Long id;
	private User user;
	private Date created;
	private String body;
	private Boolean authorized;
	
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
	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
	}
	public Boolean getAuthorized() {
		return authorized;
	}
}
