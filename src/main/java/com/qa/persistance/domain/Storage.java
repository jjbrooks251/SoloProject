package com.qa.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Storage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bId;
	private int uId;

	public Storage() {
		super();
	}

	public Storage(int bId, int uId) {
		super();
		this.bId = bId;
		this.uId = uId;
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

}
