package com.qa.persistance.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistance.domain.Rarity;
import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@Alternative
public class RarityMapRepository implements RarityRepository {

	private Map<Integer, Rarity> rarityMap = new HashMap<Integer, Rarity>();

	JSONUtil json = new JSONUtil();

	public Map<Integer, Rarity> getRarityMap() {
		return rarityMap;
	}

	public void setRarityMap(Map<Integer, Rarity> rarityMap) {
		this.rarityMap = rarityMap;
	}

	@Override
	public String getAllRarity() {

		return json.getJSONForObject(rarityMap);
	}

	@Override
	public String getRarityId(int rId) {

		Rarity rarity = getRarityMap().get(rId);

		if (getRarityMap().containsKey(rId) != false) {

			return rarity.toString();

		} else {

			return "{\"Message\": \"Desired Rarity Does Not Exist\"}";
		}
	}

	public int getRarityName(String name) {

		int count = 0;

		for (int i = 0; i < getRarityMap().size(); i++) {

			String s = getRarityMap().get(i + 1).getName();

			if (s != null && s.contains(name)) {
				count = count + 1;
			}

		}
		return count;
	}

}
