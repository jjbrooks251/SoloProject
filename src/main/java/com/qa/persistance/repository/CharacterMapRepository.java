package com.qa.persistance.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistance.domain.Character;
import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@Alternative
public class CharacterMapRepository implements CharacterRepository {

	private Map<Integer, Character> charMap = new HashMap<Integer, Character>();

	JSONUtil json = new JSONUtil();

	public Map<Integer, Character> getCharMap() {
		return charMap;
	}

	public void setCharMap(Map<Integer, Character> charMap) {
		this.charMap = charMap;
	}

	public String getAllCharacters() {

		return json.getJSONForObject(charMap);
	}

	public String getCharId(int cId) {

		Character chars = getCharMap().get(cId);

		if (getCharMap().containsKey(cId) != false) {

			return chars.toString();

		} else {

			return "{\"message\": \"Character does not exist\"}";
		}
	}

	public int getCharName(String name) {

		int count = 0;

		for (int i = 0; i < getCharMap().size(); i++) {

			String s = getCharMap().get(i + 1).getName();

			if (s != null && s.contains(name)) {
				count = count + 1;
			}

		}
		return count;
	}
	
	public String createCharacter(String user) {
		Character acc = json.getObjectForJSON(user, Character.class);

		int id = acc.getcId();

		if (getCharMap().containsKey(id) != false) {

			return "{\"message\": \"Conflicting User Id\"}";

		} else {
			charMap.put(acc.getcId(), acc);

			return "{\"message\": \"User Created\"}";
		}
	}

}
