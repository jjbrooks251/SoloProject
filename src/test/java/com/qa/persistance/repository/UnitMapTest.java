package com.qa.persistance.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistance.domain.Unit;
import com.qa.util.JSONUtil;

public class UnitMapTest {
	private JSONUtil util;
	private UnitMapRepository umr;
	
	private static final String MOCK_DATA_ARRAY1 = "[{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}]";
	private static final String MOCK_OBJECT1 = "{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}";
	private static final Unit type1 = new Unit(1, "SSJ3 Gotenks", "Super", 20, 20, 20);

	private static final String MOCK_DATA_ARRAY2 = "[{\"cId\":2,\"name\":\"SSJ Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}]";
	private static final String MOCK_OBJECT2 = "{\"cId\":2,\"name\":\"SSJ Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}";
	private static final Unit type2 = new Unit(2, "SSJ Gotenks", "Super", 20, 20, 20);

	private static final String MOCK_DATA_ARRAY3 = "[{\"cId\":13,\"name\":\"goku\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}]";
	private static final String MOCK_OBJECT3 = "{\"cId\":13,\"name\":\"goku\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}";
	private static final Unit type3 = new Unit(13, "N", "goku", 20, 20, 20);

	
	@Before
	public void setup() {
		util = new JSONUtil();
		umr = new UnitMapRepository();

	}
	
	@Test
	public void getAllUnit() {
		
		umr.getUnitMap().put(1, type1);
		assertEquals("{\"1\":" + MOCK_OBJECT1 +"}", umr.getAllUnits());
	}
	
	@Test
	public void getAllUnitEmpty() {
		assertEquals(0, umr.getUnitMap().size());
		assertEquals("{\"message\": \"Unit Map is empty\"}", umr.getAllUnits());

	}
	
	@Test
	public void getUnitId() {
		umr.getUnitMap().put(1, type1);
		umr.getUnitMap().put(2, type2);
		assertEquals("Unit [cId=2, name=SSJ Gotenks, alignment=Super, hp=20, atk=20, def=20]", umr.getUnitId(2));
	}
	
	@Test
	public void getUnitIdWrong() {
		umr.getUnitMap().put(1, type1);
		umr.getUnitMap().put(2, type2);
		assertEquals("{\"Message\": \"Unit does not exist\"}", umr.getUnitId(3));
	}
	
	@Test
	public void getUnitNameSingle() {
		umr.getUnitMap().put(1, type1);
		umr.getUnitMap().put(2, type3);
	
		assertEquals("[{\"hash\":1,\"key\":1,\"value\":" + MOCK_OBJECT1 + "}]", umr.getUnitName("SSJ"));
	}
	
	@Test
	public void getUnitNameMulti() {
		umr.getUnitMap().put(1, type1);
		umr.getUnitMap().put(2, type2);
		umr.getUnitMap().put(3, type3);
	
		assertEquals("[{\"hash\":1,\"key\":1,\"value\":" + MOCK_OBJECT1 + "},{\"hash\":2,\"key\":2,\"value\":" + MOCK_OBJECT2 + "}]", umr.getUnitName("SSJ"));
		
	}
	
	@Test
	public void getUnitNameWrong() {
		umr.getUnitMap().put(1, type1);
		umr.getUnitMap().put(2, type2);
		
		assertEquals("{\"message\": \"Result is empty\"}", umr.getUnitName("z"));
	}
}
