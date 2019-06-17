package com.qa.persistance.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
public class TypeTest {

	@InjectMocks
	private TypeDatebaseRepository repo;

	@Mock
	private EntityManager manager;

	private JSONUtil util;

	@Mock
	private Query query;
	
	private static final String MOCK_DATA_ARRAY1 = "[{\"tId\":1,\"name\":\"AGL\"}]";
	private static final String MOCK_OBJECT1 = "{\"tId\":1,\"name\":\"AGL\"}";
	private static final Type type1 = new Type(1, "AGL");
	
	private static final String MOCK_DATA_ARRAY2 = "[{\"tId\":2,\"name\":\"STR\"}]";
	private static final String MOCK_OBJECT2 = "{\"tId\":2,\"name\":\"STR\"}";
	private static final Type type2 = new Type(2, "STR");
	
	private static final String MOCK_DATA_ARRAY3 = "[{\"tId\":3,\"name\":\"TEQ\"}]";
	private static final String MOCK_OBJECT3 = "{\"tId\":3,\"name\":\"TEQ\"}";
	private static final Type type3 = new Type(3, "TEQ");
	
	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);

	}
	
	@Test
	public void getAllRarities() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Type> type = new ArrayList<>();
		type.add(type1);
		Mockito.when(query.getResultList()).thenReturn(type);
		Assert.assertEquals(MOCK_DATA_ARRAY1, repo.getAllTypes());
	}
	

	
	@Test
	public void getEmptyUsers() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Rarity> rarity = new ArrayList<>();
		
		Assert.assertEquals(0, rarity.size());

		Assert.assertEquals("{\"Message\": \"Table empty\"}", repo.getAllTypes());

	}

	@Ignore
	public void getIdExist() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Type> type = new ArrayList<>();
		type.add(type1);
		type.add(type2);
		Mockito.when(query.getResultList()).thenReturn(type);

		Assert.assertEquals(2, type.size());
		Assert.assertEquals(MOCK_DATA_ARRAY2, repo.getTypeId(2));
	}

	@Ignore
	public void getIdFail() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Type> type = new ArrayList<>();
		type.add(type1);
		type.add(type2);
		Mockito.when(query.getResultList()).thenReturn(type);

		Assert.assertEquals(2, type.size());
		Assert.assertEquals("{\"message\": \"Chosen Type id doesn't exist\"}", repo.getTypeId(3));
	}

	@Test
	public void getNameSingle() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Type> type = new ArrayList<>();
		type.add(type1);
		type.add(type2);
		Mockito.when(query.getResultList()).thenReturn(type);

		Assert.assertEquals(2, type.size());
		Assert.assertEquals(MOCK_DATA_ARRAY1, repo.getTypeName("A"));
	
	}

	@Test
	public void getNameMulti() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Type> type = new ArrayList<>();
		type.add(type1);
		type.add(type2);
		type.add(type3);
		
		Mockito.when(query.getResultList()).thenReturn(type);

		Assert.assertEquals(3, type.size());
		Assert.assertEquals("[" + MOCK_OBJECT2 + "," + MOCK_OBJECT3 + "]", repo.getTypeName("T"));
	
	}

	@Test
	public void getNameNothing() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Type> type = new ArrayList<>();
		type.add(type1);
		type.add(type2);
		Mockito.when(query.getResultList()).thenReturn(type);

		Assert.assertEquals(2, type.size());
		Assert.assertEquals("{\"message\": \"Searched Type does not exist\"}", repo.getTypeName("Z"));
	
	}
	
}
