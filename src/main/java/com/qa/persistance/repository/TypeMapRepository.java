package com.qa.persistance.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.enterprise.inject.Alternative;

import com.qa.persistance.domain.Type;
import com.qa.util.JSONUtil;

@Alternative
public class TypeMapRepository implements TypeRepository {

	private Map<Integer, Type> typeMap = new HashMap<Integer, Type>();

	JSONUtil json = new JSONUtil();

	public Map<Integer, Type> getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(Map<Integer, Type> typeMap) {
		this.typeMap = typeMap;
	}

	public String getAllTypes() {

		if (typeMap.isEmpty()) {
			return "{\"message\": \"Type Map is empty\"}";
		} else {

			return json.getJSONForObject(typeMap);
		}
	}

	public String getTypeId(int tId) {

		Type type = getTypeMap().get(tId);

		if (getTypeMap().containsKey(tId) != false) {

			return type.toString();

		} else {

			return "{\"Message\": \"Searched Type does not exist\"}";
		}
	}

	public String getTypeName(String name) {

		List<Entry<Integer, Type>> result = typeMap.entrySet().stream()
				.filter(n -> n.getValue().getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());

		if (result.isEmpty()) {
			return "{\"message\": \"Result is empty\"}";
		} else {

			return json.getJSONForObject(result);
		}
	}

}
