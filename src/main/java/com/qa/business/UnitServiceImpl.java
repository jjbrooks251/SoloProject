package com.qa.business;

import javax.inject.Inject;

import com.qa.persistance.repository.UnitRepository;

public class UnitServiceImpl implements UnitService {

	@Inject
	UnitRepository repo; 
	
	
	public String getAllUnits() {
		
		return repo.getAllUnits();
	}

	
	public String getUnitId(int cId) {
		
		return repo.getUnitId(cId);
	}

	
	public String getUnitName(String name) {
		
		return repo.getUnitName(name);
	}


	
	public String getUnitType(int tId) {
		
		return repo.getUnitType(tId);
	}


	
	public String getUnitRarity(int rId) {
		
		return repo.getUnitRarity(rId);
	}

}
