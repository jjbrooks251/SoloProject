package com.qa.repositorytests;

import org.junit.Before;

import com.qa.persistance.repository.TypeMapRepository;
import com.qa.util.JSONUtil;

public class TypeTest {

	private JSONUtil util;
	private TypeMapRepository tmr;

	@Before
	public void setup() {
		util = new JSONUtil();
		tmr = new TypeMapRepository();

	}
	
}
