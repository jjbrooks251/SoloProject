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
import com.qa.persistance.repository.TypeDatabaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class TypeSerTest {

	@InjectMocks
	public TypeServiceImpl service;

	@Mock
	public TypeDatabaseRepository repo;

	@Before
	public void setup() {

	}

	@Test
	public void getAllTypes() {
		Mockito.when(repo.getAllTypes()).thenReturn("{\"Message\": \"Table empty\"}");
		Assert.assertEquals("{\"Message\": \"Table empty\"}", service.getAllTypes());

	}

	@Test
	public void getTypeId() {
		Mockito.when(repo.getTypeId(1)).thenReturn(Constants.MOCK_TYPE_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_TYPE_DATA_ARRAY1, service.getTypeId(1));

	}

	@Test
	public void getTypeName() {
		Mockito.when(repo.getTypeName("A")).thenReturn(Constants.MOCK_TYPE_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_TYPE_DATA_ARRAY1, service.getTypeName("A"));

	}

}
