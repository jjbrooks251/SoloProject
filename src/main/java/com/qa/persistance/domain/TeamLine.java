package com.qa.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamLine {

	@Id
	private int tId;
	private int cId;

	public TeamLine() {
		super();
	}

	public TeamLine(int tId, int cId) {
		super();
		this.tId = tId;
		this.cId = cId;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

}
