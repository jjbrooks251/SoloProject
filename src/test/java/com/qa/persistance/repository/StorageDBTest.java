package com.qa.persistance.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistance.domain.Unit;
import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class StorageDBTest {

	@InjectMocks
	private StorageDatabaseRepository repo;

	@Mock
	private EntityManager manager;

	private JSONUtil util;

	@Mock
	private Query query;
	
	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);

	}

	@Test
	public void getAllStorage() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<String> entry = new ArrayList<>();

		entry.add(Constants.MOCK_STORE_OBJECT1);
		Mockito.when(query.getResultList()).thenReturn(entry);
		Assert.assertEquals("[\"{\\\"uId\\\":1,\\\"cId\\\":1}\"]", repo.findAllStorages());
	}

	@Test
	public void getAllEmpty() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		Assert.assertEquals("{\"message\": \"Table is empty\"}", repo.findAllStorages());
	}
	
	@Test
	public void createStorage() {
		Mockito.when(manager.createNativeQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<>();
		Set<Unit> units = new HashSet<>();
		
		User user = new User(1, "jjbro", "jjbro", "jjbro@qa.com", units);
		
		users.add(user);
		System.out.println(users);
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals("{\"message\": \"Unit has been added to your storage\"}", repo.createStorage(1, 1));
		
	}
	
	@Test
	public void findAStoreId() {
		List<User> users = new ArrayList<>();
		Set<Unit> units = new HashSet<>();
		
		units.add(Constants.unit1);
		units.add(Constants.unit2);
		
		User user = new User(1, "jjbro", "jjbro", "jjbro@qa.com", units);
		
		System.out.println(user);

		Mockito.when(manager.find(User.class, 1)).thenReturn(user);

		Assert.assertEquals(Constants.MOCK_STORE_DATA_ARRAY3, repo.findAStorageId(1, 1));
	
	}
	
	@Test
	public void findAStoreIdFail() {
		Set<Unit> units = new HashSet<>();
		
		units.add(Constants.unit1);
		units.add(Constants.unit2);
		
		User user = new User(1, "jjbro", "jjbro", "jjbro@qa.com", units);

		Mockito.when(manager.find(User.class, 1)).thenReturn(user);

		Assert.assertEquals("{\"message\": \"Unit does not appear in users storage\"}", repo.findAStorageId(1, 3));
	}
		
	@Test
	public void deleteAStore() {
		Mockito.when(manager.createNativeQuery(Mockito.anyString())).thenReturn(query);
		Set<Unit> units = new HashSet<>();
		
		units.add(Constants.unit1);
		units.add(Constants.unit2);
		
		User user = new User(1, "jjbro", "jjbro", "jjbro@qa.com", units);
		
		Mockito.when(manager.find(User.class, 1)).thenReturn(user);
		
		Assert.assertEquals("{\"message\": \"Unit has been deleted from your storage\"}", repo.deleteStorage(1, 1));
		
	}
	
	@Test
	public void deleteAStoreFail() {
		Mockito.when(manager.createNativeQuery(Mockito.anyString())).thenReturn(query);
		Set<Unit> units = new HashSet<>();
		
		units.add(Constants.unit1);
		units.add(Constants.unit2);
		
		User user = new User(1, "jjbro", "jjbro", "jjbro@qa.com", units);
		
		Mockito.when(manager.find(User.class, 1)).thenReturn(user);
		
		Assert.assertEquals("{\"message\": \"Unit does not appear in users storage\"}", repo.deleteStorage(1, 4));
		
	}
	
	@Test
	public void findUserStorage() {
		Set<Unit> units = new HashSet<>();
		
		units.add(Constants.unit1);
		units.add(Constants.unit2);
		
		User user = new User(1, "jjbro", "jjbro", "jjbro@qa.com", units);
		
		Mockito.when(manager.find(User.class, 1)).thenReturn(user);
		
		Assert.assertEquals(util.getJSONForObject(units), repo.findUserStorage(1));
		
	}

	@Test
	public void findUserStorageFail() {
Set<Unit> units = new HashSet<>();
		
		User user = new User(1, "jjbro", "jjbro", "jjbro@qa.com", units);
		
		Mockito.when(manager.find(User.class, 1)).thenReturn(user);
		
		Assert.assertEquals("{\"message\": \"User has no Units in storage\"}", repo.findUserStorage(1));
		
	}
}
