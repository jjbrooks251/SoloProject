package com.qa.persistance.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class UserDatabaseRepository implements UserRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil json;
	
	@Transactional(TxType.REQUIRED)
	@Override
	public String createUser(String account) {
		return null;
	}

	@Override
	public String findAllUsers() {
		return null;
	}

	@Override
	public String findAUserId(int id) {
		return null;
	}
	
	@Override
	public int findAUserName(String username) {
		return 1;
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String updateUser(int id, String account) {
		return null;
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String deleteUser(int id) {
		return null;
	}



	
}
