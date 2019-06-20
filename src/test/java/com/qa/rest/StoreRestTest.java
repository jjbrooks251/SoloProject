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

@RunWith(MockitoJUnitRunner.class)
public class StoreRestTest {

	@InjectMocks
	private StorageControl control;

	@Mock
	private StorageServiceImpl service;

	private static final String MOCK_DATA_ARRAY1 = "[{\"uId\":1,\"cId\":1}]";
	private static final String MOCK_OBJECT1 = "{\"uId\":1,\"cId\":1}";

	private static final String MOCK_DATA_ARRAY2 = "[{\"uId\":2,\"cId\":1}]";
	private static final String MOCK_OBJECT2 = "{\"uId\":2,\"cId\":1}";

	private static final String MOCK_DATA_ARRAY3 = "[{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}]";
	
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
		Mockito.when(service.findAStorageId(1, 1)).thenReturn(MOCK_DATA_ARRAY3);
		Assert.assertEquals(MOCK_DATA_ARRAY3, control.findAStorageId(1, 1));
	
	}
	
	
	@Test
	public void deleteStorage() {
		Mockito.when(service.deleteStorage(1, 1)).thenReturn("{\"message\": \"Unit has been deleted from your storage\"}");
		Assert.assertEquals("{\"message\": \"Unit has been deleted from your storage\"}", control.deleteStorage(1, 1));
	
	}
	
	
	@Test
	public void findUserStorage() {
		Mockito.when(service.findUserStorage(1)).thenReturn(MOCK_DATA_ARRAY3);
		Assert.assertEquals(MOCK_DATA_ARRAY3, control.findUserStorage(1));
	
	}
}
