package com.qa.persistance.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RarityMapTest {

	private RarityMapRepository rmr;
	
	@Before
	public void setup() {
		rmr = new RarityMapRepository();

	}
	
	@Test
	public void getAllRarity() {
		
		rmr.getRarityMap().put(1, Constants.rare1);
		assertEquals("{\"1\":" + Constants.MOCK_RARE_OBJECT1 +"}", rmr.getAllRarity());
	}
	
	@Test
	public void getAllRarityEmpty() {
		assertEquals(0, rmr.getRarityMap().size());
		assertEquals("{\"message\": \"Rarity Map is empty\"}", rmr.getAllRarity());

	}
	
	@Test
	public void getRarityId() {
		rmr.getRarityMap().put(1, Constants.rare1);
		rmr.getRarityMap().put(2, Constants.rare2);
		assertEquals("Rarity [rId=2, name=R, lvMax=40]", rmr.getRarityId(2));
	}
	
	@Test
	public void getRarityIdWrong() {
		rmr.getRarityMap().put(1, Constants.rare1);
		rmr.getRarityMap().put(2, Constants.rare2);
		assertEquals("{\"Message\": \"Desired Rarity Does Not Exist\"}", rmr.getRarityId(3));
	}
	
	@Test
	public void getRarityNameSingle() {
		rmr.getRarityMap().put(1, Constants.rare1);
		rmr.getRarityMap().put(2, Constants.rare2);
	
		assertEquals("[{\"hash\":2,\"key\":2,\"value\":" + Constants.MOCK_RARE_OBJECT2 + "}]", rmr.getRarityName("R"));
	}
	
	@Test
	public void getRarityNameMulti() {
		rmr.getRarityMap().put(1, Constants.rare1);
		rmr.getRarityMap().put(2, Constants.rare2);
		rmr.getRarityMap().put(3, Constants.rare3);
	
		assertEquals("[{\"hash\":2,\"key\":2,\"value\":" +Constants.MOCK_RARE_OBJECT2 + "},{\"hash\":3,\"key\":3,\"value\":" + Constants.MOCK_RARE_OBJECT3 + "}]", rmr.getRarityName("R"));
		
	}
	
	@Test
	public void getRarityNameWrong() {
		rmr.getRarityMap().put(1, Constants.rare1);
		rmr.getRarityMap().put(2, Constants.rare2);
		
		assertEquals("{\"message\": \"Result is empty\"}", rmr.getRarityName("z"));
	}
	
}
