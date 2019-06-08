package com.qa.persistance.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@Alternative
public class UserMapRepository implements UserRepository {

	private Map<Integer, User> userMap = new HashMap<Integer, User>();

	JSONUtil json = new JSONUtil();

	public Map<Integer, User> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<Integer, User> userMap) {
		this.userMap = userMap;
	}

	
	public String createUser(String user) {
		User acc = json.getObjectForJSON(user, User.class);

		userMap.put(acc.getuId(), acc);

		return "{\"message\": \"Account Created\"}";
	}

	
	public String findAllUsers() {

		return userMap.toString();
	}

	
	public String findAUser(int id) {

		
		
		return null;
	}

	
	public String updateUser(int id, String user) {
		User acc = json.getObjectForJSON(user, User.class);

		userMap.replace(id, acc);
		
		return "{\"Message\": \"Account Updated\"}";
		}

	
	public String deleteUser(int id) {
		
		userMap.remove(id);
		
		return "{\"Message\": \"Account Deleted\"}";
	}

}
