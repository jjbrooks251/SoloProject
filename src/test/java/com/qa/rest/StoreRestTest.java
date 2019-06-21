package com.qa.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.StorageServiceImpl;
import com.qa.persistance.repository.Constants;

@RunWith(MockitoJUnitRunner.class)
public class StoreRestTest {

	@InjectMocks
	private StorageControl control;

	@Mock
	private StorageServiceImpl service;

	@Before
	public void setup() {

	}
	
	@Test
	public void createStorage() {
		Mockito.when(service.createStorage(1, 1)).thenReturn("{\"message\": \"Unit has been added to your storage\"}");
		Assert.assertEquals("{\"message\": \"Unit has been added to your storage\"}", control.createStorage(1, 1));
	
	}
	
	@Test
	public void findAllStorages() {
		Mockito.when(service.findAllStorages()).thenReturn("{\"message\": \"Table is empty\"}");
		Assert.assertEquals("{\"message\": \"Table is empty\"}", control.findAllStorages());
	
	}
	
	
	@Test
	public void findAStorageId() {
		Mockito.when(service.findAStorageId(1, 1)).thenReturn(Constants.MOCK_STORE_DATA_ARRAY3);
		Assert.assertEquals(Constants.MOCK_STORE_DATA_ARRAY3, control.findAStorageId(1, 1));
	
	}
	
	
	@Test
	public void deleteStorage() {
		Mockito.when(service.deleteStorage(1, 1)).thenReturn("{\"message\": \"Unit has been deleted from your storage\"}");
		Assert.assertEquals("{\"message\": \"Unit has been deleted from your storage\"}", control.deleteStorage(1, 1));
	
	}
	
	
	@Test
	public void findUserStorage() {
		Mockito.when(service.findUserStorage(1)).thenReturn(Constants.MOCK_STORE_DATA_ARRAY3);
		Assert.assertEquals(Constants.MOCK_STORE_DATA_ARRAY3, control.findUserStorage(1));
	
	}
}
