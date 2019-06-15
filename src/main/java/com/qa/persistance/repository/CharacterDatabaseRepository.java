package com.qa.persistance.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class CharacterDatabaseRepository implements CharacterRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllCharacters() {
		
		Query query = manager.createQuery("SELECT c FROM Character c");

		Collection<Character> chars = (Collection<Character>) query.getResultList();

		return util.getJSONForObject(chars);
	}

	
	public String getCharId(int cId) {
		
		Character char1 = manager.find(Character.class, cId);

		if (char1 != null) {

			return util.getJSONForObject(char1);
		} else {
			return "{\"message\": \"Character doesn't exist\"}";
		}
	}

	
	public int getCharName(String name) {
		
		return 1;
	}

}
