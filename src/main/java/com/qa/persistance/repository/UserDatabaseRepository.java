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
	public String createUser(String user) {
		User clas1 = util.getObjectForJSON(user, User.class);

		int id = clas1.getuId();

		if (manager.find(User.class, id) != null) {
			return "{\"message\": \"User with this id already exists\"}";
		} else {

			manager.persist(clas1);

			return "{\"message\": \"New User Created\"}";
		}

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

	public String findAUserName(String username) {
		Query query = manager.createQuery("SELECT a FROM User a");

		Collection<User> users = (Collection<User>) query.getResultList();
		
		List<User> result = users.stream().filter(n -> n.getUsername().contains(username)).collect(Collectors.toList());

		if (result.isEmpty()) {

			return "{\"message\": \"User does not exist\"}";

		} else {
			return util.getJSONForObject(result);
		}
	}

	@Transactional(TxType.REQUIRED)
	public String updateUser(int id, String user) {
		User old = manager.find(User.class, id);
		User update = util.getObjectForJSON(user, User.class);

		if (old != null) {
			old.setUsername(update.getUsername());
			old.setPassword(update.getPassword());
			old.setEmail(update.getEmail());

			manager.persist(old);
			return "{\"message\": \"User Updated\"}";
		} else {
			return "{\"message\": \"User does not exist\"}";
		}
	}

	@Transactional(TxType.REQUIRED)
	public String deleteUser(int id) {
		User user1 = manager.find(User.class, id);

		if (user1 != null) {
			manager.remove(user1);
			return "{\"message\": \"User Deleted\"}";
		} else {
			return "{\"message\": \"User with this id doesn't exist\"}";
		}
	}

}
