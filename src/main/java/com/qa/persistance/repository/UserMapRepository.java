package com.qa.persistance.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.enterprise.inject.Alternative;

import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@Alternative
public class UserMapRepository implements UserRepository {

	private Map<Integer, User> userMap = new HashMap<>();

	JSONUtil json = new JSONUtil();

	String userexist = "{\"message\": \"User does not exist\"}";
	
	public Map<Integer, User> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<Integer, User> userMap) {
		this.userMap = userMap;
	}

	public String createUser(String user) {
		User acc = json.getObjectForJSON(user, User.class);

		int id = acc.getuId();

		if (getUserMap().containsKey(id)) {

			return "{\"message\": \"Conflicting User Id\"}";

		} else {
			userMap.put(acc.getuId(), acc);

			return "{\"message\": \"User Created\"}";
		}
	}

	public String findAllUsers() {

		if (getUserMap().isEmpty()) {
			return "{\"message\": \"Map of Users is empty\"}";
		} else {

			return json.getJSONForObject(userMap);
		}
	}

	public String findAUserId(int id) {

		User user = getUserMap().get(id);

		if (getUserMap().containsKey(id)) {

			return user.toString();

		} else {

			return userexist;
		}
	}

	public String findAUserName(String username) {
		
		List<Entry<Integer, User>> result = userMap.entrySet().stream()
				.filter(n -> n.getValue().getUsername().toLowerCase().contains(username.toLowerCase())).collect(Collectors.toList());

		if (result.isEmpty()) {
			return userexist;
		} else {

			return json.getJSONForObject(result);
		}
	}

	public String updateUser(int id, String user) {
		User oldClas = getUserMap().get(id);
		User newClas = json.getObjectForJSON(user, User.class);

		if (oldClas != null) {

			getUserMap().put(id, newClas);

			return "{\"message\": \"User Updated\"}";
		} else {
			return userexist;
		}
	}

	public String deleteUser(int id) {

		if (getUserMap().containsKey(id)) {
			userMap.remove(id);

			return "{\"Message\": \"User Deleted\"}";

		} else {

			return "{\"Message\": \"User does not exist\"}";
		}
	}


	public String findAUserNameExact(String username) {
		
		return null;
	}

}
