package com.qa.persistance.repository;

public interface CharacterRepository {

	public String getAllCharacters();
	
	public String getCharId(int cId);
	
	public int getCharName(String name);
}
