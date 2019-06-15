package com.qa.repositorytests;

import org.junit.Before;

import com.qa.persistance.repository.RarityMapRepository;
import com.qa.util.JSONUtil;

public class RarityTest {

	private JSONUtil util;
	private RarityMapRepository rmr;

	@Before
	public void setup() {
		util = new JSONUtil();
		rmr = new RarityMapRepository();

	}
	
}
