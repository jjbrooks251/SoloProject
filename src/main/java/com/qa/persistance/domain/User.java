package com.qa.persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;
	@Column(length = 30)
	private String username;
	@Column(length = 30)
	private String password;
	@Column(length = 255)
	private String email;

	public User() {
		super();
	}

	public User(int uId, String username, String password, String email) {
		super();
		this.uId = uId;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User: " + uId + ", " + username + ", " + password + ", " + email;
	}
	
	

}
