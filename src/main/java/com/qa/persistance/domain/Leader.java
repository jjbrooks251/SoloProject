package com.qa.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Leader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int lId;
	private int boost;
	private int which;

	public Leader() {
		super();
	}

	public Leader(int lId, int boost, int which) {
		super();
		this.lId = lId;
		this.boost = boost;
		this.which = which;
	}

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public int getBoost() {
		return boost;
	}

	public void setBoost(int boost) {
		this.boost = boost;
	}

	public int getWhich() {
		return which;
	}

	public void setWhich(int which) {
		this.which = which;
	}

}
