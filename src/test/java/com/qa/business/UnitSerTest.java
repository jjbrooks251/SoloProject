package com.qa.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistance.repository.UnitDatabaseRepository;
import com.qa.persistance.repository.UserDatabaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class UnitSerTest {

	@InjectMocks
	public UnitServiceImpl service;

	@Mock
	private UnitDatabaseRepository repo;
	
	private static final String MOCK_DATA_ARRAY1 = "[{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}]";
	
	
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
		Mockito.when(repo.getUnitId(1)).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, service.getUnitId(1));
	
	}
	
	@Test
	public void getUnitName() {
		Mockito.when(repo.getUnitName("j")).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, service.getUnitName("j"));
	
	}
}
