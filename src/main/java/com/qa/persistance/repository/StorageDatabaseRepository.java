package com.qa.persistance.repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistance.domain.Unit;
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
				.createNativeQuery(String.format("INSERT INTO User_Unit(USER_uId, UNIT_cId) VALUES (%s,%s)", uId, cId));

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
		User user1 = manager.find(User.class, uId);

		Set<Unit> unit = user1.getCharacters();

		List<Unit> result = unit.stream().filter(n -> n.getcId() == cId).collect(Collectors.toList());

		if (result.isEmpty()) {
			return "{\"message\": \"Unit does not appear in users storage\"}";
		} else {
			return util.getJSONForObject(result);

		}

	}

	@Transactional(TxType.REQUIRED)
	public String deleteStorage(int uId, int cID) {
		User user1 = manager.find(User.class, uId);

		Set<Unit> unit = user1.getCharacters();

		List<Unit> result = unit.stream().filter(n -> n.getcId() == cID).collect(Collectors.toList());

		if (result.isEmpty()) {
			return "{\"message\": \"Unit does not appear in users storage\"}";
		} else {
			Query query = manager.createNativeQuery(
					String.format("DELETE FROM User_Unit WHERE user_uID = %s AND unit_cId = %s", uId, cID));

			query.executeUpdate();

			return "{\"message\": \"Unit has been deleted from your storage\"}";
		}
	}

	public String findUserStorage(int uId) {
		User user1 = manager.find(User.class, uId);

		Set<Unit> unit = user1.getCharacters();

		if (unit.isEmpty()) {
			return "{\"message\": \"User has no Units in storage\"}";
		} else {
			return util.getJSONForObject(unit);

		}
	}

}
