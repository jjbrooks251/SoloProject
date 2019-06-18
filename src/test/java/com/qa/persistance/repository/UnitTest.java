package com.qa.persistance.repository;

import static org.junit.Assert.assertEquals;

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

import com.qa.persistance.domain.Unit;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class UnitTest {

	@InjectMocks
	private UnitDatabaseRepository repo;

	@Mock
	private EntityManager manager;

	private JSONUtil util;

	@Mock
	private Query query;
	
	private static final String MOCK_DATA_ARRAY1 = "[{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}]";
	private static final String MOCK_OBJECT1 = "{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}";
	private static final Unit unit1 = new Unit(1, "SSJ3 Gotenks", "Super", 20, 20, 20);
	
	private static final String MOCK_DATA_ARRAY2 = "[{\"cId\":2,\"name\":\"SSJ Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}]";
	private static final String MOCK_OBJECT2 = "{\"cId\":2,\"name\":\"SSJ Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}";
	private static final Unit unit2 = new Unit(2, "SSJ Gotenks", "Super", 20, 20, 20);
	
	
	private static final String MOCK_DATA_ARRAY3 = "[{\"cId\":13,\"name\":\"goku\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}]";
	private static final String MOCK_OBJECT3 = "{\"cId\":13,\"name\":\"goku\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20}";
	private static final Unit unit3 = new Unit(13, "N", "goku", 20, 20, 20);
	
	
	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);

	}
	
	@Test
	public void getAllRarities() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();
		unit.add(unit1);
		Mockito.when(query.getResultList()).thenReturn(unit);
		Assert.assertEquals(MOCK_DATA_ARRAY1, repo.getAllUnits());
	}
	

	
	@Test
	public void getEmptyUsers() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();
		
		Assert.assertEquals(0, unit.size());

		Assert.assertEquals("{\"Message\": \"Table empty\"}", repo.getAllUnits());

	}

	@Ignore
	public void getIdExist() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();
		
		unit.add(unit1);
		unit.add(unit2);
		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(2, unit.size());
		Assert.assertEquals(MOCK_DATA_ARRAY2, repo.getUnitId(2));
	}

	@Ignore
	public void getIdFail() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();
		
		unit.add(unit1);
		unit.add(unit2);
		Assert.assertEquals(2, unit.size());
		Assert.assertEquals("{\"Message\": \"Desired Unit Doesn't Exist\"}", repo.getUnitId(3));
	}

	@Test
	public void getNameSingle() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();
		
		unit.add(unit1);
		unit.add(unit3);
		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(2, unit.size());
		Assert.assertEquals(MOCK_DATA_ARRAY1, repo.getUnitName("Gotenks"));

	}

	@Test
	public void getNameMulti() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();
		
		unit.add(unit1);
		unit.add(unit2);
		unit.add(unit3);
		
		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(3, unit.size());
		Assert.assertEquals("[" + MOCK_OBJECT1 + "," + MOCK_OBJECT2 + "]", repo.getUnitName("Gotenks"));

	}

	@Test
	public void getNameNothing() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();
		
		unit.add(unit1);
		unit.add(unit2);
		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(2, unit.size());
		Assert.assertEquals("{\"message\": \"Unit does not exist\"}", repo.getUnitName("z"));

	}
	
}
