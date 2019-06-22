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

	private Map<Integer, Unit> unitMap = new HashMap<Integer, Unit>();

	JSONUtil json = new JSONUtil();

	public Map<Integer, Unit> getUnitMap() {
		return unitMap;
	}

	public void setUnitMap(Map<Integer, Unit> UnitMap) {
		this.unitMap = UnitMap;
	}

	public String getAllUnits() {

		if (unitMap.isEmpty()) {
			return "{\"message\": \"Unit Map is empty\"}";
		} else {

			return json.getJSONForObject(unitMap);
		}
	}

	public String getUnitId(int cId) {

		Unit units = getUnitMap().get(cId);

		if (getUnitMap().containsKey(cId) == true) {

			return units.toString();

		} else {

			return "{\"Message\": \"Unit does not exist\"}";
		}
	}

	public String getUnitName(String name) {

		List<Entry<Integer, Unit>> result = unitMap.entrySet().stream()
				.filter(n -> n.getValue().getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());

		if (result.isEmpty()) {
			return "{\"message\": \"Result is empty\"}";
		} else {

			return json.getJSONForObject(result);
		}
	}

	@Override
	public String getUnitType(int tId) {
		List<Entry<Integer, Unit>> result = unitMap.entrySet().stream()
				.filter(n -> n.getValue().getType() == tId).collect(Collectors.toList());

		if (result.isEmpty()) {
			return "{\"message\": \"Result is empty\"}";
		} else {

			return json.getJSONForObject(result);
		}
	}

	@Override
	public String getUnitRarity(int rId) {
		List<Entry<Integer, Unit>> result = unitMap.entrySet().stream()
				.filter(n -> n.getValue().getRarity() == rId).collect(Collectors.toList());

		if (result.isEmpty()) {
			return "{\"message\": \"Result is empty\"}";
		} else {

			return json.getJSONForObject(result);
		}
	}

}
