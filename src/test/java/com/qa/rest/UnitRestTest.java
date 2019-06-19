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

import com.qa.business.UnitServiceImpl;
import com.qa.persistance.repository.UnitDatabaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class UnitRestTest {
	@InjectMocks
	public UnitControl control;
	
	@Mock
	public UnitServiceImpl service;

	@Mock
	private UnitDatabaseRepository repo;

	private static final String MOCK_DATA_ARRAY1 = "[{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}]";
	
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
		Mockito.when(service.getUnitId(1)).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, control.getUnitId(1));
	
	}
	
	@Test
	public void getUnitName() {
		Mockito.when(service.getUnitName("j")).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, control.getUnitName("j"));
	
	}
}
