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

import com.qa.business.RarityServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RareRestTest {
	@InjectMocks
	public RarityControl control;

	@Mock
	public RarityServiceImpl service;
	
	private static final String MOCK_DATA_ARRAY1 = "[{\"rId\":1,\"name\":\"N\",\"lvMax\":20}]";
	
	
	@Before
	public void setup() {

	}

	@Test
	public void getAllRarity() {
		Mockito.when(service.getAllRarity()).thenReturn("{\"Message\": \"Table empty\"}");
		Assert.assertEquals("{\"Message\": \"Table empty\"}", control.getAllRarity());
	
	}

	@Test
	public void getRarityId() {
		Mockito.when(service.getRarityId(1)).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, control.getRarityId(1));
	}

	@Test
	public void getRarityName() {
		Mockito.when(service.getRarityName("N")).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, control.getRarityName("N"));
	}
}
