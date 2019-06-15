package com.qa.persistance.repository;

import java.util.Collection;

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
public class TypeDatebaseRepository implements TypeRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllTypes() {
		Query query = manager.createQuery("SELECT t FROM Type t");

		Collection<Type> types = (Collection<Type>) query.getResultList();

		return util.getJSONForObject(types);
	}

	
	public String getTypeId(int tId) {
		Type type = manager.find(Type.class, tId);

		if (type != null) {

			return util.getJSONForObject(type);
		} else {
			return "{\"message\": \"Searched Type with this id doesn't exist\"}";
		}
	}

	
	public String getTypeName(String name) {

		return "{\"message\": \"Searched Type with this name exists\"}";
	}

	
	
}
