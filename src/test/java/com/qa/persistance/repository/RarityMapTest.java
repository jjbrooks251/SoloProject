package com.qa.persistance.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistance.domain.Rarity;
import com.qa.util.JSONUtil;

public class RarityMapTest {

	private JSONUtil util;
	private RarityMapRepository rmr;

	private static final String MOCK_OBJECT1 = "{\"rId\":1,\"name\":\"N\",\"lvMax\":20}";
	private static final Rarity rare1 = new Rarity(1, "N", 20);

	private static final String MOCK_OBJECT2 = "{\"rId\":2,\"name\":\"R\",\"lvMax\":40}";
	private static final Rarity rare2 = new Rarity(2, "R", 40);

	private static final String MOCK_OBJECT3 = "{\"rId\":3,\"name\":\"SR\",\"lvMax\":60}";
	private static final Rarity rare3 = new Rarity(3, "SR", 60);
	
	@Before
	public void setup() {
		util = new JSONUtil();
		rmr = new RarityMapRepository();

	}
	
	@Test
	public void getAllRarity() {
		
		rmr.getRarityMap().put(1, rare1);
		assertEquals("{\"1\":" + MOCK_OBJECT1 +"}", rmr.getAllRarity());
	}
	
	@Test
	public void getAllRarityEmpty() {
		assertEquals(0, rmr.getRarityMap().size());
		assertEquals("{\"message\": \"Rarity Map is empty\"}", rmr.getAllRarity());

	}
	
	@Test
	public void getRarityId() {
		rmr.getRarityMap().put(1, rare1);
		rmr.getRarityMap().put(2, rare2);
		assertEquals("Rarity [rId=2, name=R, lvMax=40]", rmr.getRarityId(2));
	}
	
	@Test
	public void getRarityIdWrong() {
		rmr.getRarityMap().put(1, rare1);
		rmr.getRarityMap().put(2, rare2);
		assertEquals("{\"Message\": \"Desired Rarity Does Not Exist\"}", rmr.getRarityId(3));
	}
	
	@Test
	public void getRarityNameSingle() {
		rmr.getRarityMap().put(1, rare1);
		rmr.getRarityMap().put(2, rare2);
	
		assertEquals("[{\"hash\":2,\"key\":2,\"value\":" + MOCK_OBJECT2 + "}]", rmr.getRarityName("R"));
	}
	
	@Test
	public void getRarityNameMulti() {
		rmr.getRarityMap().put(1, rare1);
		rmr.getRarityMap().put(2, rare2);
		rmr.getRarityMap().put(3, rare3);
	
		assertEquals("[{\"hash\":2,\"key\":2,\"value\":" + MOCK_OBJECT2 + "},{\"hash\":3,\"key\":3,\"value\":" + MOCK_OBJECT3 + "}]", rmr.getRarityName("R"));
		
	}
	
	@Test
	public void getRarityNameWrong() {
		rmr.getRarityMap().put(1, rare1);
		rmr.getRarityMap().put(2, rare2);
		
		assertEquals("{\"message\": \"Result is empty\"}", rmr.getRarityName("z"));
	}
	
}
