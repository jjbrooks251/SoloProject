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

import com.qa.persistance.repository.Constants;
import com.qa.persistance.repository.StorageDatabaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class StoreSerTest {

	@InjectMocks
	private StorageServiceImpl service;

	@Mock
	private StorageDatabaseRepository repo;

	
	@Before
	public void setup() {

	}
	
	@Test
	public void createStorage() {
		Mockito.when(repo.createStorage(1, 1)).thenReturn("{\"message\": \"Unit has been added to your storage\"}");
		Assert.assertEquals("{\"message\": \"Unit has been added to your storage\"}", service.createStorage(1, 1));
	
	}
	
	@Test
	public void findAllStorages() {
		Mockito.when(repo.findAllStorages()).thenReturn("{\"message\": \"Table is empty\"}");
		Assert.assertEquals("{\"message\": \"Table is empty\"}", service.findAllStorages());
	
	}
	
	
	@Test
	public void findAStorageId() {
		Mockito.when(repo.findAStorageId(1, 1)).thenReturn(Constants.MOCK_STORE_DATA_ARRAY3);
		Assert.assertEquals(Constants.MOCK_STORE_DATA_ARRAY3, service.findAStorageId(1, 1));
	
	}
	
	
	@Test
	public void deleteStorage() {
		Mockito.when(repo.deleteStorage(1, 1)).thenReturn("{\"message\": \"Unit has been deleted from your storage\"}");
		Assert.assertEquals("{\"message\": \"Unit has been deleted from your storage\"}", service.deleteStorage(1, 1));
	
	}
	
	
	@Test
	public void findUserStorage() {
		Mockito.when(repo.findUserStorage(1)).thenReturn(Constants.MOCK_STORE_DATA_ARRAY3);
		Assert.assertEquals(Constants.MOCK_STORE_DATA_ARRAY3, service.findUserStorage(1));
	
	}
	
	
}
