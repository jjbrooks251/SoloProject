package com.qa.repositorytests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistance.repository.CharacterMapRepository;
import com.qa.util.JSONUtil;

public class CharacterTest {

	private JSONUtil util;
	private CharacterMapRepository cmr;

	@Before
	public void setup() {
		util = new JSONUtil();
		cmr = new CharacterMapRepository();

	}
	
	@Test
	public void findCharId() {

		assertEquals(0, cmr.getCharMap().size());
		
	cmr.createCharacter(Constants.char1);
		
	assertEquals(1, cmr.getCharMap().size());
		
	}
	
}
