package com.qa.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.RarityServiceImpl;
import com.qa.persistance.repository.Constants;

@RunWith(MockitoJUnitRunner.class)
public class RareRestTest {
	@InjectMocks
	public RarityControl control;

	@Mock
	public RarityServiceImpl service;
	
	
	
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
		Mockito.when(service.getRarityId(1)).thenReturn(Constants.MOCK_RARE_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_RARE_DATA_ARRAY1, control.getRarityId(1));
	}

	@Test
	public void getRarityName() {
		Mockito.when(service.getRarityName("N")).thenReturn(Constants.MOCK_RARE_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_RARE_DATA_ARRAY1, control.getRarityName("N"));
	}
}
