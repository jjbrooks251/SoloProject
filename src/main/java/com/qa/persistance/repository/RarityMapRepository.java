package com.qa.persistance.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.enterprise.inject.Alternative;

import com.qa.persistance.domain.Rarity;
import com.qa.util.JSONUtil;

@Alternative
public class RarityMapRepository implements RarityRepository {

	private Map<Integer, Rarity> rarityMap = new HashMap<>();

	JSONUtil json = new JSONUtil();

	public Map<Integer, Rarity> getRarityMap() {
		return rarityMap;
	}

	public void setRarityMap(Map<Integer, Rarity> rarityMap) {
		this.rarityMap = rarityMap;
	}

	@Override
	public String getAllRarity() {

		if (getRarityMap().isEmpty()) {
			return "{\"message\": \"Rarity Map is empty\"}";
		} else {

			return json.getJSONForObject(rarityMap);
		}
	}

	@Override
	public String getRarityId(int rId) {

		Rarity rarity = getRarityMap().get(rId);

		if (getRarityMap().containsKey(rId)) {

			return rarity.toString();

		} else {

			return "{\"Message\": \"Desired Rarity Does Not Exist\"}";
		}
	}

	public String getRarityName(String name) {

		List<Entry<Integer, Rarity>> result = rarityMap.entrySet().stream()
				.filter(n -> n.getValue().getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());

		if (result.isEmpty()) {
			return "{\"message\": \"Result is empty\"}";
		} else {

			return json.getJSONForObject(result);
		}
	}

}
