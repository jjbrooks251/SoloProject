package com.qa.persistance.repository;

public interface UnitRepository {

	public String getAllUnits();
	
	public String getUnitId(int cId);
	
	public String getUnitName(String name);
	
	public String getUnitType(int tId);
	
	public String getUnitRarity(int rId);
}
