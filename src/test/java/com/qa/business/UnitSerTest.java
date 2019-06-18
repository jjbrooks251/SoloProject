package com.qa.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UnitSerTest {

	@InjectMocks
	public UnitServiceImpl service;

	@Before
	public void setup() {

	}

	@Test
	public void getAllUnits() {
		Assert.assertEquals(1, 1);
	}
	
	@Ignore
	public void getUnitId() {

	}
	
	@Ignore
	public void getUnitName() {

	}
}
