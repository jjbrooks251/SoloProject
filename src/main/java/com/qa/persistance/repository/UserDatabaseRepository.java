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

	String usersql = "SELECT a FROM User a";
	String userempty = "{\"message\": \"User doesn't exist\"}";
	
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
	public String createUser(String user) {
		User user1 = util.getObjectForJSON(user, User.class);

		manager.persist(user1);

		return "{\"message\": \"New User Created\"}";

	}

	public String findAllUsers() {
		Query query = manager.createQuery(usersql);

		Collection<User> users = (Collection<User>) query.getResultList();

		if (users.isEmpty()) {
			return "{\"message\": \"User Field is empty\"}";
		} else {

			return util.getJSONForObject(users);
		}
	}

	public String findAUserId(int id) {
		User user1 = manager.find(User.class, id);

		if (user1 != null) {
			return util.getJSONForObject(user1);
		} else {
			return userempty;
		}
	}

	public String findAUserName(String username) {
		Query query = manager.createQuery(usersql);

		Collection<User> users = (Collection<User>) query.getResultList();

		List<User> result = users.stream().filter(n -> n.getUsername().toLowerCase().contains(username.toLowerCase())).collect(Collectors.toList());

		if (result.isEmpty()) {

			return userempty;

		} else {
			return util.getJSONForObject(result);
		}
	}

	@Transactional(TxType.REQUIRED)
	public String updateUser(int id, String user) {
		User old = manager.find(User.class, id);
		User update = util.getObjectForJSON(user, User.class);

		if (update.getPassword() == null) {
			update.setPassword(old.getPassword());
		}
		
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

	@Override
	public String findAUserNameExact(String username) {
		Query query = manager.createQuery(usersql);

		Collection<User> users = (Collection<User>) query.getResultList();

		List<User> result = users.stream().filter(n -> n.getUsername().equals(username)).collect(Collectors.toList());

		if (result.isEmpty()) {

			return userempty;

		} else {
			return util.getJSONForObject(result);
		}
	}

}
