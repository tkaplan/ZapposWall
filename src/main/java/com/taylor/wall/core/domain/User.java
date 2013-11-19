package com.taylor.wall.core.domain;

import java.util.Date;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

public class User {
	private Long id;
	private List<Post> posts;
	private Date created;
	private String email;
	private String username;
	private String password;
	private Boolean verified;
	
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
	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password,BCrypt.gensalt(13));
	}
	public Boolean checkPassword(String password) {
		return BCrypt.checkpw(password, this.password);
	}
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	public Boolean getVerified() {
		return verified;
	}
}
