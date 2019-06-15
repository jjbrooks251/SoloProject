package com.qa.business;

import javax.inject.Inject;

import com.qa.persistance.repository.CharacterRepository;

public class CharacterServiceImpl implements CharacterService {

	@Inject
	CharacterRepository repo; 
	
	
	public String getAllCharacters() {
		
		return repo.getAllCharacters();
	}

	
	public String getCharId(int cId) {
		
		return repo.getCharId(cId);
	}

	
	public int getCharName(String name) {
		
		return repo.getCharName(name);
	}

}
