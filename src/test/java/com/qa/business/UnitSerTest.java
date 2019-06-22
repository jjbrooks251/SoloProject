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
import com.qa.persistance.repository.UnitDatabaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class UnitSerTest {

	@InjectMocks
	public UnitServiceImpl service;

	@Mock
	private UnitDatabaseRepository repo;
	
	
	@Before
	public void setup() {

	}

	@Test
	public void getAllUnits() {
		Mockito.when(repo.getAllUnits()).thenReturn("{\"Message\": \"Table empty\"}");
		Assert.assertEquals("{\"Message\": \"Table empty\"}", service.getAllUnits());
	
	}
	
	@Test
	public void getUnitId() {
		Mockito.when(repo.getUnitId(1)).thenReturn(Constants.MOCK_UNIT_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_UNIT_DATA_ARRAY1, service.getUnitId(1));
	
	}
	
	@Test
	public void getUnitName() {
		Mockito.when(repo.getUnitName("j")).thenReturn(Constants.MOCK_UNIT_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_UNIT_DATA_ARRAY1, service.getUnitName("j"));
	
	}
	
	@Test
	public void getUnitType() {
		Mockito.when(repo.getUnitType(2)).thenReturn(Constants.MOCK_UNIT_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_UNIT_DATA_ARRAY1, service.getUnitType(2));
	
	}
	
	@Test
	public void getUnitRarity() {
		Mockito.when(repo.getUnitRarity(2)).thenReturn(Constants.MOCK_UNIT_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_UNIT_DATA_ARRAY1, service.getUnitRarity(2));
	
	}
}
