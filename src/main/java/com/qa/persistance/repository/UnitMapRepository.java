package com.qa.persistance.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.enterprise.inject.Alternative;

import com.qa.persistance.domain.Unit;
import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@Alternative
public class UnitMapRepository implements UnitRepository {

	private Map<Integer, Unit> UnitMap = new HashMap<Integer, Unit>();

	JSONUtil json = new JSONUtil();

	public Map<Integer, Unit> getUnitMap() {
		return UnitMap;
	}

	public void setUnitMap(Map<Integer, Unit> UnitMap) {
		this.UnitMap = UnitMap;
	}

	public String getAllUnits() {

		return json.getJSONForObject(UnitMap);
	}

	public String getUnitId(int cId) {

		Unit Units = getUnitMap().get(cId);

		if (getUnitMap().containsKey(cId) != false) {

			return Units.toString();

		} else {

			return "{\"message\": \"Unit does not exist\"}";
		}
	}

	public String getUnitName(String name) {

		List<Entry<Integer, Unit>> result = UnitMap.entrySet().stream()
				.filter(n -> n.getValue().getName().contains(name)).collect(Collectors.toList());

		return json.getJSONForObject(result);
	}
	
	public String createUnit(String user) {
		Unit acc = json.getObjectForJSON(user, Unit.class);

		int id = acc.getcId();

		if (getUnitMap().containsKey(id) != false) {

			return "{\"message\": \"Conflicting User Id\"}";

		} else {
			UnitMap.put(acc.getcId(), acc);

			return "{\"message\": \"User Created\"}";
		}
	}

}
