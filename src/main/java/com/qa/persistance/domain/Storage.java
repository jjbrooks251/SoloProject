package com.qa.persistance.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Storage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bId;
	private int uId;
	@OneToMany(cascade = CascadeType.ALL)
    private Set<Character> box = new HashSet<Character>();

	public Storage() {
		super();
	}

	
	
	public Storage(int bId, int uId, Set<Character> box) {
		super();
		this.bId = bId;
		this.uId = uId;
		this.box = box;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public Set<Character> getDecks() {
		return box;
	}

	public void setDecks(Set<Character> box) {
		this.box = box;
	}
	
	

}
