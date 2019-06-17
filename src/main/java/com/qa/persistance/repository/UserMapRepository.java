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

		int id = acc.getuId();

		if (getUserMap().containsKey(id) != false) {

			return "{\"message\": \"Conflicting User Id\"}";

		} else {
			userMap.put(acc.getuId(), acc);

			return "{\"message\": \"User Created\"}";
		}
	}

	public String findAllUsers() {

		if (getUserMap().size() == 0) {
			return "{\"message\": \"Map of Users is empty\"}";
		} else {

			return json.getJSONForObject(userMap);
		}
	}

	public String findAUserId(int id) {

		User user = getUserMap().get(id);

		if (getUserMap().containsKey(id) != false) {

			return user.toString();

		} else {

			return "{\"message\": \"User does not exist\"}";
		}
	}

	public String findAUserName(String username) {

		List<Entry<Integer, User>> result = userMap.entrySet().stream()
				.filter(n -> n.getValue().getUsername().contains(username)).collect(Collectors.toList());

		return json.getJSONForObject(result);
	}

	public String updateUser(int id, String user) {
		User oldClas = getUserMap().get(id);
		User newClas = json.getObjectForJSON(user, User.class);

		if (oldClas != null) {

			getUserMap().put(id, newClas);

			return "{\"message\": \"User Updated\"}";
		} else {
			return "{\"message\": \"User does not exist\"}";
		}
	}

	public String deleteUser(int id) {

		if (getUserMap().containsKey(id) != false) {
			userMap.remove(id);

			return "{\"Message\": \"Account Deleted\"}";

		} else {

			return "{\"Message\": \"Account does not exist\"}";
		}
	}

}
