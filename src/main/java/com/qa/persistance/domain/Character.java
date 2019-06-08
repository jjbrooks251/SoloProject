package com.qa.persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;
	@Column(length = 30)
	private String name;
	private int typeId;
	private String alignment;
	private int rId;
	private int hp;
	private int atk;
	private int def;
	private int lId;
	private int catId;

	public Character() {
		super();
	}

	public Character(int cId, String name, int typeId, String alignment, int rId, int hp, int atk, int def, int lId,
			int catId) {
		super();
		this.cId = cId;
		this.name = name;
		this.typeId = typeId;
		this.alignment = alignment;
		this.rId = rId;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.lId = lId;
		this.catId = catId;
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

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
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

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

}
