package com.qa.persistance.repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
public class RarityDatabaseRepository implements RarityRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	public String getAllRarity() {

		Query query = manager.createQuery("SELECT r FROM Rarity r");

		Collection<Rarity> rare = (Collection<Rarity>) query.getResultList();

		if (rare.isEmpty()) {
			return "{\"Message\": \"Table empty\"}";
		} else {

			return util.getJSONForObject(rare);
		}
	}

	public String getRarityId(int rId) {

		Rarity rare1 = manager.find(Rarity.class, rId);

		if (rare1 != null) {

			return util.getJSONForObject(rare1);
		} else {
			return "{\"Message\": \"Desired Rarity Doesn't Exist\"}";
		}

	}

	public String getRarityName(String name) {

		Query query = manager.createQuery("SELECT r FROM Rarity r");

		Collection<Rarity> rarities = (Collection<Rarity>) query.getResultList();

		List<Rarity> result = rarities.stream().filter(n -> n.getName().contains(name)).collect(Collectors.toList());

		if (result.isEmpty()) {

			return "{\"message\": \"Searched rarity does not exist\"}";

		} else {
			return util.getJSONForObject(result);
		}
	}

}
