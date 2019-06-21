package com.qa.persistance.repository;

import java.util.ArrayList;
import java.util.List;

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

import com.qa.persistance.domain.Rarity;
import com.qa.persistance.domain.Type;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TypeDBTest {

	@InjectMocks
	private TypeDatabaseRepository repo;

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
	public void getAllTypes() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Type> type = new ArrayList<>();
		type.add(Constants.type1);
		Mockito.when(query.getResultList()).thenReturn(type);
		Assert.assertEquals(Constants.MOCK_TYPE_DATA_ARRAY1, repo.getAllTypes());
	}
	
	@Test
	public void getEmptyTypes() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Rarity> rarity = new ArrayList<>();
		
		Assert.assertEquals(0, rarity.size());

		Assert.assertEquals("{\"Message\": \"Table empty\"}", repo.getAllTypes());

	}

	@Test
	public void getIdExist() {
		List<Type> type = new ArrayList<>();
		type.add(Constants.type1);
		type.add(Constants.type2);
	
		Mockito.when(manager.find(Type.class, 2)).thenReturn(Constants.type2);

		Assert.assertEquals(2, type.size());
		Assert.assertEquals(Constants.MOCK_TYPE_OBJECT2, repo.getTypeId(2));
	}

	@Test
	public void getIdFail() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Type> type = new ArrayList<>();
		type.add(Constants.type1);
		type.add(Constants.type2);
	
		Mockito.when(manager.find(Type.class, 2)).thenReturn(Constants.type2);

		Assert.assertEquals(2, type.size());
		Assert.assertEquals("{\"message\": \"Chosen Type id doesn't exist\"}", repo.getTypeId(3));
	}

	@Test
	public void getNameSingle() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Type> type = new ArrayList<>();
		type.add(Constants.type1);
		type.add(Constants.type2);
		Mockito.when(query.getResultList()).thenReturn(type);

		Assert.assertEquals(2, type.size());
		Assert.assertEquals(Constants.MOCK_TYPE_DATA_ARRAY1, repo.getTypeName("A"));
	
	}

	@Test
	public void getNameMulti() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Type> type = new ArrayList<>();
		type.add(Constants.type1);
		type.add(Constants.type2);
		type.add(Constants.type3);
		
		Mockito.when(query.getResultList()).thenReturn(type);

		Assert.assertEquals(3, type.size());
		Assert.assertEquals("[" + Constants.MOCK_TYPE_OBJECT2 + "," + Constants.MOCK_TYPE_OBJECT3 + "]", repo.getTypeName("T"));
	
	}

	@Test
	public void getNameNothing() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Type> type = new ArrayList<>();
		type.add(Constants.type1);
		type.add(Constants.type2);
		Mockito.when(query.getResultList()).thenReturn(type);

		Assert.assertEquals(2, type.size());
		Assert.assertEquals("{\"message\": \"Searched Type does not exist\"}", repo.getTypeName("Z"));
	
	}
	
}
