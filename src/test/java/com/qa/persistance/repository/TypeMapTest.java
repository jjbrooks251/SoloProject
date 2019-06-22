package com.qa.persistance.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistance.domain.Type;
import com.qa.util.JSONUtil;

public class TypeMapTest {
	private TypeMapRepository tmr;
	
	@Before
	public void setup() {
		tmr = new TypeMapRepository();

	}
	
	@Test
	public void getAllType() {
		
		tmr.getTypeMap().put(1, Constants.type1);
		assertEquals("{\"1\":" + Constants.MOCK_TYPE_OBJECT1 +"}", tmr.getAllTypes());
	}
	
	@Test
	public void getAllTypeEmpty() {
		assertEquals(0, tmr.getTypeMap().size());
		assertEquals("{\"message\": \"Type Map is empty\"}", tmr.getAllTypes());

	}
	
	@Test
	public void getTypeId() {
		tmr.getTypeMap().put(1, Constants.type1);
		tmr.getTypeMap().put(2, Constants.type2);
		assertEquals("Type [tId=2, name=STR]", tmr.getTypeId(2));
	}
	
	@Test
	public void getTypeIdWrong() {
		tmr.getTypeMap().put(1, Constants.type1);
		tmr.getTypeMap().put(2, Constants.type2);
		assertEquals("{\"Message\": \"Searched Type does not exist\"}", tmr.getTypeId(3));
	}
	
	@Test
	public void getTypeNameSingle() {
		tmr.getTypeMap().put(1, Constants.type1);
		tmr.getTypeMap().put(2, Constants.type2);
	
		assertEquals("[{\"hash\":2,\"key\":2,\"value\":" + Constants.MOCK_TYPE_OBJECT2 + "}]", tmr.getTypeName("R"));
	}
	
	@Test
	public void getTypeNameMulti() {
		tmr.getTypeMap().put(1, Constants.type1);
		tmr.getTypeMap().put(2, Constants.type2);
		tmr.getTypeMap().put(3, Constants.type3);
	
		assertEquals("[{\"hash\":2,\"key\":2,\"value\":" + Constants.MOCK_TYPE_OBJECT2 + "},{\"hash\":3,\"key\":3,\"value\":" + Constants.MOCK_TYPE_OBJECT3 + "}]", tmr.getTypeName("T"));
		
	}
	
	@Test
	public void getTypeNameWrong() {
		tmr.getTypeMap().put(1, Constants.type1);
		tmr.getTypeMap().put(2, Constants.type2);
		
		assertEquals("{\"message\": \"Result is empty\"}", tmr.getTypeName("z"));
	}
}
