package com.qa.business;

import javax.inject.Inject;

import com.qa.persistance.repository.RarityRepository;

public class RarityServiceImpl implements RarityService {

	@Inject
	RarityRepository repo; 
	
	public String getAllRarity() {
		
		return repo.getAllRarity();
	}

	
	public String getRarityId(int rId) {
	
		return repo.getRarityId(rId);
	}

	
	public int getRarityName(String name) {
	
		return repo.getRarityName(name);
	}
	
	

}
