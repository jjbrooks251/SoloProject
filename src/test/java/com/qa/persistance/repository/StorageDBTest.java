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

	private static final String MOCK_DATA_ARRAY1 = "[{\\\"uId\\\":1,\\\"cId\\\":1}]";
	private static final String MOCK_OBJECT1 = "{\"uId\":1,\"cId\":1}";

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

		entry.add(MOCK_OBJECT1);
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
		List<User> users = new ArrayList<User>();
		Set<Unit> units = new HashSet<>();
		
		Unit unit = new Unit(1, "unit", "super", 30, 30, 30);
		User user = new User(1, "jjbro", "jjbro", "jjbro@qa.com", units);
		
		users.add(user);
		System.out.println(users);
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals("{\"message\": \"Unit has been added to your storage\"}", repo.createStorage(1, 1));
		
	}

}
