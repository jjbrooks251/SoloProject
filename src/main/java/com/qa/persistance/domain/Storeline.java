package com.qa.persistance.domain;

import javax.persistence.Entity;

@Entity
public class Storeline {

	private int sId;
	private int cId;

	public Storeline() {
		super();
	}

	public Storeline(int sId, int cId) {
		super();
		this.sId = sId;
		this.cId = cId;
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

}
