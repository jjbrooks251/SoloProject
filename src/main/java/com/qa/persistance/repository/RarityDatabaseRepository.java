package com.qa.persistance.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistance.domain.Rarity;
import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class RarityDatabaseRepository implements RarityRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllRarity() {
	
		Query query = manager.createQuery("SELECT r FROM Rarity r");

		Collection<Rarity> rare = (Collection<Rarity>) query.getResultList();

		return util.getJSONForObject(rare);
	}

	public String getRarityId(int rId) {
	
		Rarity rare1 = manager.find(Rarity.class, rId);

		if (rare1 != null) {

			return util.getJSONForObject(rare1);
		} else {
			return "{\"Message\": \"Desired Rarity Doesn't Exist\"}";
		}
	
	}

	public int getRarityName(String name) {
	
		return 0;
	}

}
