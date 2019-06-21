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

import com.qa.persistance.domain.Type;
import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class TypeDatabaseRepository implements TypeRepository {

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

	@Override
	public String getAllTypes() {
		Query query = manager.createQuery("SELECT t FROM Type t");

		Collection<Type> types = (Collection<Type>) query.getResultList();

		if (types.isEmpty()) {
			return "{\"Message\": \"Table empty\"}";
		} else {
		
		return util.getJSONForObject(types);
		}
	}

	@Override
	public String getTypeId(int tId) {
		Type type1 = manager.find(Type.class, tId);

		if (type1 != null) {

			return util.getJSONForObject(type1);
		} else {
			return "{\"message\": \"Chosen Type id doesn't exist\"}";
		}
	}

	@Override
	public String getTypeName(String name) {
		Query query = manager.createQuery("SELECT t FROM Type t");

		Collection<Type> types = (Collection<Type>) query.getResultList();

		List<Type> result = types.stream().filter(n -> n.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());

		if (result.isEmpty()) {

			return "{\"message\": \"Searched Type does not exist\"}";

		} else {
			return util.getJSONForObject(result);
		}
	}

}
