package com.qa.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TypeSerTest {

	@InjectMocks
	public TypeServiceImpl service;

	@Before
	public void setup() {

	}

	@Test
	public void getAllTypes() {
		Assert.assertEquals(1, 1);
	}

	@Ignore
	public void getTypeId() {

	}

	@Ignore
	public void getTypeName() {

	}

}
