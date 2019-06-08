package com.qa.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Storeline {

	
	@Id
	private int sId;
	private int cId;
	private int lv;

	public Storeline() {
		super();
	}

	public Storeline(int sId, int cId, int lv) {
		super();
		this.sId = sId;
		this.cId = cId;
		this.lv = lv;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}
	
	

}
