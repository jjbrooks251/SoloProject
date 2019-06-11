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
public class UserDatabaseRepository implements UserRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	@Transactional(TxType.REQUIRED)
	public String createUser(String account) {
		return null;
	}

	public String findAllUsers() {
		Query query = manager.createQuery("SELECT a FROM User a");

		Collection<User> users = (Collection<User>) query.getResultList();

		return util.getJSONForObject(users);
	}

	public String findAUserId(int id) {
		User user1 = manager.find(User.class, id);

		if (user1 != null) {

			return util.getJSONForObject(user1);
		} else {
			return "{\"message\": \"User doesn't exist\"}";
		}
	}
	
	public int findAUserName(String username) {
		
		// List<Movie> validList = movies.stream().filter(n -> n.getTitle().equals(title)).collect(Collectors.toList());
		
		return 1;
	}

	@Transactional(TxType.REQUIRED)
	public String updateUser(int id, String account) {
		return null;
	}

	@Transactional(TxType.REQUIRED)
	public String deleteUser(int id) {
		return null;
	}



	
}
