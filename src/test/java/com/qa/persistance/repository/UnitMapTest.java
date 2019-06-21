package com.qa.persistance.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UnitMapTest {
	private UnitMapRepository umr;
	
	@Before
	public void setup() {
		umr = new UnitMapRepository();

	}
	
	@Test
	public void getAllUnit() {
		
		umr.getUnitMap().put(1, Constants.unit1);
		assertEquals("{\"1\":" + Constants.MOCK_UNIT_OBJECT1 +"}", umr.getAllUnits());
	}
	
	@Test
	public void getAllUnitEmpty() {
		assertEquals(0, umr.getUnitMap().size());
		assertEquals("{\"message\": \"Unit Map is empty\"}", umr.getAllUnits());

	}
	
	@Test
	public void getUnitId() {
		umr.getUnitMap().put(1, Constants.unit1);
		umr.getUnitMap().put(2, Constants.unit2);
		assertEquals("Unit [cId=2, name=SSJ Gotenks, alignment=Super, hp=20, atk=20, def=20, type=1, rarity=1]", umr.getUnitId(2));
	}
	
	@Test
	public void getUnitIdWrong() {
		umr.getUnitMap().put(1, Constants.unit1);
		umr.getUnitMap().put(2, Constants.unit2);
		assertEquals("{\"Message\": \"Unit does not exist\"}", umr.getUnitId(3));
	}
	
	@Test
	public void getUnitNameSingle() {
		umr.getUnitMap().put(1, Constants.unit1);
		umr.getUnitMap().put(2, Constants.unit3);
	
		assertEquals("[{\"hash\":1,\"key\":1,\"value\":" + Constants.MOCK_UNIT_OBJECT1 + "}]", umr.getUnitName("SSJ"));
	}
	
	@Test
	public void getUnitNameMulti() {
		umr.getUnitMap().put(1, Constants.unit1);
		umr.getUnitMap().put(2, Constants.unit2);
		umr.getUnitMap().put(3, Constants.unit3);
	
		assertEquals("[{\"hash\":1,\"key\":1,\"value\":" + Constants.MOCK_UNIT_OBJECT1 + "},{\"hash\":2,\"key\":2,\"value\":" + Constants.MOCK_UNIT_OBJECT2 + "}]", umr.getUnitName("SSJ"));
		
	}
	
	@Test
	public void getUnitNameWrong() {
		umr.getUnitMap().put(1, Constants.unit1);
		umr.getUnitMap().put(2, Constants.unit2);
		
		assertEquals("{\"message\": \"Result is empty\"}", umr.getUnitName("z"));
	}
	
	@Test
	public void getUnitType() {
		umr.getUnitMap().put(1, Constants.unit1);
		umr.getUnitMap().put(2, Constants.unit2);
		umr.getUnitMap().put(3, Constants.unit3);
	
		assertEquals("[{\"hash\":1,\"key\":1,\"value\":" + Constants.MOCK_UNIT_OBJECT1 + "},{\"hash\":3,\"key\":3,\"value\":" + Constants.MOCK_UNIT_OBJECT3 + "}]", umr.getUnitType(2));
		
	}
	
	@Test
	public void getUnitTypeWrong() {
		umr.getUnitMap().put(1, Constants.unit1);
		umr.getUnitMap().put(2, Constants.unit2);
		
		assertEquals("{\"message\": \"Result is empty\"}", umr.getUnitType(3));
	}
	
	@Test
	public void getUnitRarity() {
		umr.getUnitMap().put(1, Constants.unit1);
		umr.getUnitMap().put(2, Constants.unit2);
		umr.getUnitMap().put(3, Constants.unit3);
	
		assertEquals("[{\"hash\":1,\"key\":1,\"value\":" + Constants.MOCK_UNIT_OBJECT1 + "},{\"hash\":3,\"key\":3,\"value\":" + Constants.MOCK_UNIT_OBJECT3 + "}]", umr.getUnitRarity(2));
	}
	
	@Test
	public void getUnitRarityWrong() {
		umr.getUnitMap().put(1, Constants.unit1);
		umr.getUnitMap().put(2, Constants.unit2);
		
		assertEquals("{\"message\": \"Result is empty\"}", umr.getUnitRarity(3));
	}
	
	
}
