package com.qa.persistance.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_unit", joinColumns = @JoinColumn(name = "user_uId"), inverseJoinColumns = @JoinColumn(name = "unit_cId"))
	private Set<Unit> characters = new HashSet<>();
	
	public User() {
		super();
	}

	public User(int uId, String username, String password, String email, Set<Unit> characters) {
		super();
		this.uId = uId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.characters = characters;
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

	public Set<Unit> getCharacters() {
		return characters;
	}

	public void setCharacters(Set<Unit> characters) {
		this.characters = characters;
	}

	@Override
	public String toString() {
		return "User: " + uId + ", " + username + ", " + password + ", " + email + ", " + characters;
	}
	
	

}
