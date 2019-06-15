package com.qa.persistance.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistance.domain.Type;
import com.qa.util.JSONUtil;

@Alternative
public class TypeMapRepository implements TypeRepository{

	private Map<Integer, Type> typeMap = new HashMap<Integer, Type>();

	JSONUtil json = new JSONUtil();
	
	public Map<Integer, Type> getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(Map<Integer, Type> typeMap) {
		this.typeMap = typeMap;
	}

	public String getAllTypes() {
		
		return json.getJSONForObject(typeMap);
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
	
		return "{\"Message\": \"Searched Type exists\"}";
	}

}
