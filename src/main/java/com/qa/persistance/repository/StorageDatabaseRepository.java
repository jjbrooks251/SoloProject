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
	public String createStorage(int uId, int cId) {
		Query query = manager
				.createNativeQuery(String.format("INSERT INTO User_Character(USER_uId, UNIT_cId) VALUES (%s,%s)", uId, cId));

		query.executeUpdate();
		return "{\"message\": \"Unit has been added to your storage\"}";
	}

	public String findAllStorages() {
		Query query = manager.createQuery("SELECT s FROM User_Unit s");

		if (query.getResultList().isEmpty()) {
			return "{\"message\": \"Table is empty\"}";
		} else {

			return util.getJSONForObject(query.getResultList());
		}
	}

	public String findAStorageId(int uId, int cId) {
		return null;
	}

	@Transactional(TxType.REQUIRED)
	public String deleteStorage(int uId, int cID) {
		return "{\"message\": \"Unit has been added deleted from your storage\"}";
	}

}
