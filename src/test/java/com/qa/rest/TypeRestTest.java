package com.qa.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.TypeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TypeRestTest {
	@InjectMocks
	public TypeControl control;

	@Mock
	public TypeServiceImpl service;

	private static final String MOCK_DATA_ARRAY1 = "[{\"tId\":1,\"name\":\"AGL\"}]";

	@Before
	public void setup() {

	}

	@Test
	public void getAllTypes() {
		Mockito.when(service.getAllTypes()).thenReturn("{\"Message\": \"Table empty\"}");
		Assert.assertEquals("{\"Message\": \"Table empty\"}", control.getAllTypes());
	}

	@Test
	public void getTypeId() {
		Mockito.when(service.getTypeId(1)).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, control.getTypeId(1));
	}

	@Test
	public void getTypeName() {
		Mockito.when(service.getTypeName("A")).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, control.getTypeName("A"));
	}
}
