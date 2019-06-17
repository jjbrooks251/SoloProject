package com.qa.persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	@Column(length = 30)
	private String name;
	private String alignment;
	private int hp;
	private int atk;
	private int def;
	
//	@ManyToOne
//	private Type type;
	
//	@ManyToOne
//	private Rarity rarity;

	public Character() {
		super();
	}

	public Character(int cId, String name, String alignment, int hp, int atk, int def) {
	super();
	this.cId = cId;
	this.name = name;
	this.alignment = alignment;
	this.hp = hp;
	this.atk = atk;
	this.def = def;
}



	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}


	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	@Override
	public String toString() {
		return "Unit [cId=" + cId + ", name=" + name + ", alignment=" + alignment + ", hp=" + hp + ", atk=" + atk
				+ ", def=" + def + "]";
	}

	

}
