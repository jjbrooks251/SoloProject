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

import com.qa.persistance.domain.Team;
import com.qa.persistance.domain.Unit;
import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class UnitDBTest {

	@InjectMocks
	private UnitDatabaseRepository repo;

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
	public void getAllUnits() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();
		unit.add(Constants.unit1);
		Mockito.when(query.getResultList()).thenReturn(unit);
		Assert.assertEquals(Constants.MOCK_UNIT_DATA_ARRAY1, repo.getAllUnits());
	}

	@Test
	public void getEmptyUnits() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();

		Assert.assertEquals(0, unit.size());

		Assert.assertEquals("{\"Message\": \"Table empty\"}", repo.getAllUnits());

	}

	@Test
	public void getIdExist() {
		List<Unit> unit = new ArrayList<>();

		unit.add(Constants.unit1);
		unit.add(Constants.unit2);

		Mockito.when(manager.find(Unit.class, 2)).thenReturn(Constants.unit2);

		Assert.assertEquals(2, unit.size());
		Assert.assertEquals(Constants.MOCK_UNIT_OBJECT2, repo.getUnitId(2));
	}

	@Test
	public void getIdFail() {
		List<Unit> unit = new ArrayList<>();

		unit.add(Constants.unit1);
		unit.add(Constants.unit2);

		Mockito.when(manager.find(Unit.class, 2)).thenReturn(Constants.unit2);

		Assert.assertEquals(2, unit.size());
		Assert.assertEquals("{\"message\": \"Unit doesn't exist\"}", repo.getUnitId(3));
	}

	@Test
	public void getNameSingle() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();

		unit.add(Constants.unit1);
		unit.add(Constants.unit3);
		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(2, unit.size());
		Assert.assertEquals(Constants.MOCK_UNIT_DATA_ARRAY1, repo.getUnitName("Gotenks"));

	}

	@Test
	public void getNameMulti() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();

		unit.add(Constants.unit1);
		unit.add(Constants.unit2);
		unit.add(Constants.unit3);

		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(3, unit.size());
		Assert.assertEquals("[" + Constants.MOCK_UNIT_OBJECT1 + "," +Constants.MOCK_UNIT_OBJECT2 + "]", repo.getUnitName("Gotenks"));

	}

	@Test
	public void getNameNothing() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();

		unit.add(Constants.unit1);
		unit.add(Constants.unit2);
		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(2, unit.size());
		Assert.assertEquals("{\"message\": \"Unit does not exist\"}", repo.getUnitName("z"));

	}

	@Test
	public void getTypeSingle() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();

		unit.add(Constants.unit1);
		unit.add(Constants.unit2);
		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(2, unit.size());
		Assert.assertEquals(Constants.MOCK_UNIT_DATA_ARRAY1, repo.getUnitType(2));

	}

	@Test
	public void getTypeMulti() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();

		unit.add(Constants.unit1);
		unit.add(Constants.unit2);
		unit.add(Constants.unit3);

		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(3, unit.size());
		Assert.assertEquals("[" + Constants.MOCK_UNIT_OBJECT1 + "," +Constants.MOCK_UNIT_OBJECT3 + "]", repo.getUnitType(2));

	}

	@Test
	public void getTypeNothing() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();

		unit.add(Constants.unit1);
		unit.add(Constants.unit2);
		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(2, unit.size());
		Assert.assertEquals("{\"message\": \"Type does not exist\"}", repo.getUnitType(3));

	}

	@Test
	public void getRaritySingle() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();

		unit.add(Constants.unit1);
		unit.add(Constants.unit2);
		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(2, unit.size());
		Assert.assertEquals(Constants.MOCK_UNIT_DATA_ARRAY1, repo.getUnitRarity(2));

	}

	@Test
	public void getRarityMulti() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();

		unit.add(Constants.unit1);
		unit.add(Constants.unit2);
		unit.add(Constants.unit3);

		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(3, unit.size());
		Assert.assertEquals("[" + Constants.MOCK_UNIT_OBJECT1 + "," + Constants.MOCK_UNIT_OBJECT3 + "]", repo.getUnitRarity(2));

	}

	@Test
	public void getRarityNothing() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> unit = new ArrayList<>();

		unit.add(Constants.unit1);
		unit.add(Constants.unit2);
		Mockito.when(query.getResultList()).thenReturn(unit);

		Assert.assertEquals(2, unit.size());
		Assert.assertEquals("{\"message\": \"Rarity does not exist\"}", repo.getUnitRarity(3));

	}

}
