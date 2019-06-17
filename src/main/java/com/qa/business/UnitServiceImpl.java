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

}
