package com.qa.persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rarity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rId;
	@Column(length = 3)
	private String name;
	private int lvMax;

	public Rarity() {
		super();
	}

	public Rarity(int rId, String name, int lvMax) {
		super();
		this.rId = rId;
		this.name = name;
		this.lvMax = lvMax;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLvMax() {
		return lvMax;
	}

	public void setLvMax(int lvMax) {
		this.lvMax = lvMax;
	}

}
