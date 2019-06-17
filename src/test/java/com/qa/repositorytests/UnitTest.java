package com.qa.repositorytests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistance.repository.UnitMapRepository;
import com.qa.util.JSONUtil;

public class UnitTest {

	private JSONUtil util;
	private UnitMapRepository cmr;

	@Before
	public void setup() {
		util = new JSONUtil();
		cmr = new UnitMapRepository();

	}
	
	@Test
	public void findCharId() {

		assertEquals(0, cmr.getUnitMap().size());
		
	cmr.createUnit(Constants.char1);
		
	assertEquals(1, cmr.getUnitMap().size());
		
	}
	
}
