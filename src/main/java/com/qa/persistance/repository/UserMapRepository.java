package com.qa.persistance.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

			return "User does not exist";
		}
	}

	public int findAUserName(String username) {

		int count = 0;

		for (int i = 0; i < getUserMap().size(); i++) {

			String s = getUserMap().get(i + 1).getUsername();

			if (s != null && s.contains(username)) {
				count = count + 1;
			}

			// List<String> names =
			// userMap.entrySet().stream().filter(t->t.startsWith("S")).collect(Collectors.toList());

		}
		return count;
	}

	public String updateUser(int id, String user) {
		User acc = json.getObjectForJSON(user, User.class);

		userMap.replace(id, acc);

		return "{\"Message\": \"Account Updated\"}";
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
