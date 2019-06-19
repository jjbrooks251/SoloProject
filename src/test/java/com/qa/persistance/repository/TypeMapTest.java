package com.qa.persistance.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistance.domain.Type;
import com.qa.util.JSONUtil;

public class TypeMapTest {
	private JSONUtil util;
	private TypeMapRepository tmr;
	
	private static final String MOCK_DATA_ARRAY1 = "[{\"tId\":1,\"name\":\"AGL\"}]";
	private static final String MOCK_OBJECT1 = "{\"tId\":1,\"name\":\"AGL\"}";
	private static final Type type1 = new Type(1, "AGL");
	
	private static final String MOCK_DATA_ARRAY2 = "[{\"tId\":2,\"name\":\"STR\"}]";
	private static final String MOCK_OBJECT2 = "{\"tId\":2,\"name\":\"STR\"}";
	private static final Type type2 = new Type(2, "STR");
	
	private static final String MOCK_DATA_ARRAY3 = "[{\"tId\":3,\"name\":\"TEQ\"}]";
	private static final String MOCK_OBJECT3 = "{\"tId\":3,\"name\":\"TEQ\"}";
	private static final Type type3 = new Type(3, "TEQ");
	
	@Before
	public void setup() {
		util = new JSONUtil();
		tmr = new TypeMapRepository();

	}
	
	@Test
	public void getAllType() {
		
		tmr.getTypeMap().put(1, type1);
		assertEquals("{\"1\":" + MOCK_OBJECT1 +"}", tmr.getAllTypes());
	}
	
	@Test
	public void getAllTypeEmpty() {
		assertEquals(0, tmr.getTypeMap().size());
		assertEquals("{\"message\": \"Type Map is empty\"}", tmr.getAllTypes());

	}
	
	@Test
	public void getTypeId() {
		tmr.getTypeMap().put(1, type1);
		tmr.getTypeMap().put(2, type2);
		assertEquals("Type [tId=2, name=STR]", tmr.getTypeId(2));
	}
	
	@Test
	public void getTypeIdWrong() {
		tmr.getTypeMap().put(1, type1);
		tmr.getTypeMap().put(2, type2);
		assertEquals("{\"Message\": \"Searched Type does not exist\"}", tmr.getTypeId(3));
	}
	
	@Test
	public void getTypeNameSingle() {
		tmr.getTypeMap().put(1, type1);
		tmr.getTypeMap().put(2, type2);
	
		assertEquals("[{\"hash\":2,\"key\":2,\"value\":" + MOCK_OBJECT2 + "}]", tmr.getTypeName("R"));
	}
	
	@Test
	public void getTypeNameMulti() {
		tmr.getTypeMap().put(1, type1);
		tmr.getTypeMap().put(2, type2);
		tmr.getTypeMap().put(3, type3);
	
		assertEquals("[{\"hash\":2,\"key\":2,\"value\":" + MOCK_OBJECT2 + "},{\"hash\":3,\"key\":3,\"value\":" + MOCK_OBJECT3 + "}]", tmr.getTypeName("T"));
		
	}
	
	@Test
	public void getTypeNameWrong() {
		tmr.getTypeMap().put(1, type1);
		tmr.getTypeMap().put(2, type2);
		
		assertEquals("{\"message\": \"Result is empty\"}", tmr.getTypeName("z"));
	}
}
