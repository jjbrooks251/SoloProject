package com.qa.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.UnitServiceImpl;
import com.qa.persistance.repository.Constants;
import com.qa.persistance.repository.UnitDatabaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class UnitRestTest {
	@InjectMocks
	public UnitControl control;

	@Mock
	public UnitServiceImpl service;

	@Mock
	private UnitDatabaseRepository repo;

	@Before
	public void setup() {

	}

	@Test
	public void getAllUnits() {
		Mockito.when(service.getAllUnits()).thenReturn("{\"Message\": \"Table empty\"}");
		Assert.assertEquals("{\"Message\": \"Table empty\"}", control.getAllUnits());

	}

	@Test
	public void getUnitId() {
		Mockito.when(service.getUnitId(1)).thenReturn(Constants.MOCK_UNIT_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_UNIT_DATA_ARRAY1, control.getUnitId(1));

	}

	@Test
	public void getUnitName() {
		Mockito.when(service.getUnitName("j")).thenReturn(Constants.MOCK_UNIT_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_UNIT_DATA_ARRAY1, control.getUnitName("j"));

	}

	@Test
	public void getUnitType() {
		Mockito.when(service.getUnitType(2)).thenReturn(Constants.MOCK_UNIT_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_UNIT_DATA_ARRAY1, control.getUnitType(2));

	}

	@Test
	public void getUnitRarity() {
		Mockito.when(service.getUnitRarity(2)).thenReturn(Constants.MOCK_UNIT_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_UNIT_DATA_ARRAY1, control.getUnitRarity(2));

	}
}
