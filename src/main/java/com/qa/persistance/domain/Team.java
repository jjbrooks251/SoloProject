package com.qa.persistance.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;

	@ManyToOne
	private User user;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "team_character", joinColumns = @JoinColumn(name = "team_tId"), inverseJoinColumns = @JoinColumn(name = "character_cId"))
	private Set<Character> characters = new HashSet<>();

	public Team() {
		super();
	}

	public Team(int tId, User user, Set<Character> characters) {
		super();
		this.tId = tId;
		this.user = user;
		this.characters = characters;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	 public Set<Character> getCharacters() {
	 return characters;
	 }
	
	 public void setCharacters(Set<Character> characters) {
	 this.characters = characters;
	 }

}