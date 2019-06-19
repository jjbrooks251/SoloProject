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
public class StorageDatabaseRepository implements StorageRepository {

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

	@Transactional(TxType.REQUIRED)
	public String createStorage(String storage) {
		return null;
	}

	public String findAllStorages() {
		Query query = manager.createQuery("SELECT s FROM User_Unit s");

		Collection<User> users = (Collection<User>) query.getResultList();
		
		if (users.isEmpty()) {
			return "{\"message\": \"Table is empty\"}";
		}else {
		
		return util.getJSONForObject(users);
	}
	}

	public String findAStorageId(int id) {
		return null;
	}

	public String findAStorageName(String storagename) {
		return null;
	}

	@Transactional(TxType.REQUIRED)
	public String updateStorage(int id, String storage) {
		return null;
	}

	@Transactional(TxType.REQUIRED)
	public String deleteStorage(int id) {
		return null;
	}

}
