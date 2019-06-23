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

import com.qa.persistance.domain.Unit;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class UnitDatabaseRepository implements UnitRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	String sql = "SELECT c FROM Unit c";
	
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

	public String getAllUnits() {

		Query query = manager.createQuery(sql);

		Collection<Unit> units = (Collection<Unit>) query.getResultList();

		if (units.isEmpty()) {
			return "{\"Message\": \"Table empty\"}";
		} else {

			return util.getJSONForObject(units);
		}
	}

	public String getUnitId(int cId) {

		Unit target = manager.find(Unit.class, cId);

		if (target != null) {

			return util.getJSONForObject(target);

		} else {
			return "{\"message\": \"Unit doesn't exist\"}";
		}
	}

	public String getUnitName(String name) {

		Query query1 = manager.createQuery(sql);

		Collection<Unit> units = (Collection<Unit>) query1.getResultList();

		List<Unit> result = units.stream().filter(n -> n.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());

		if (result.isEmpty()) {

			return "{\"message\": \"Unit does not exist\"}";

		} else {
			return util.getJSONForObject(result);
		}
	}

	public String getUnitType(int tId) {

		Query query2 = manager.createQuery(sql);

		Collection<Unit> units = (Collection<Unit>) query2.getResultList();

		List<Unit> result = units.stream().filter(n -> n.getType() == tId)
				.collect(Collectors.toList());

		if (result.isEmpty()) {

			return "{\"message\": \"Type does not exist\"}";

		} else {
			return util.getJSONForObject(result);
		}
	}

	public String getUnitRarity(int rId) {

		Query query3 = manager.createQuery(sql);

		Collection<Unit> units = (Collection<Unit>) query3.getResultList();

		List<Unit> result = units.stream().filter(n -> n.getRarity() == rId)
				.collect(Collectors.toList());

		if (result.isEmpty()) {

			return "{\"message\": \"Rarity does not exist\"}";

		} else {
			return util.getJSONForObject(result);
		}
	}

}
