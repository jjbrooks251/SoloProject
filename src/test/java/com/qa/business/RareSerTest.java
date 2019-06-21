package com.qa.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistance.repository.Constants;
import com.qa.persistance.repository.RarityDatabaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class RareSerTest {

	@InjectMocks
	public RarityServiceImpl service;

	@Mock
	public RarityDatabaseRepository repo;
	
	@Before
	public void setup() {

	}

	@Test
	public void getAllRarity() {
		Mockito.when(repo.getAllRarity()).thenReturn("{\"Message\": \"Table empty\"}");
		Assert.assertEquals("{\"Message\": \"Table empty\"}", service.getAllRarity());
	}

	@Test
	public void getRarityId() {
		Mockito.when(repo.getRarityId(1)).thenReturn(Constants.MOCK_RARE_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_RARE_DATA_ARRAY1, service.getRarityId(1));
	}

	@Test
	public void getRarityName() {
		Mockito.when(repo.getRarityName("N")).thenReturn(Constants.MOCK_RARE_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_RARE_DATA_ARRAY1, service.getRarityName("N"));
	}
}
