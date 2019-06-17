package com.qa.persistance.repository;

import java.util.Collection;

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

	public String getAllUnits() {

		Query query = manager.createQuery("SELECT c FROM Unit c");

		Collection<Unit> Units = (Collection<Unit>) query.getResultList();

		return util.getJSONForObject(Units);
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

		return "hello";
	}

}
