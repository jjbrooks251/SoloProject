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
import com.qa.persistance.repository.RarityDatabaseRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class RarityDBTest {

	@InjectMocks
	private RarityDatabaseRepository repo;

	@Mock
	private EntityManager manager;

	private JSONUtil util;

	@Mock
	private Query query;

	private static final String MOCK_STORE_DATA_ARRAY1 = "[{\"rId\":1,\"name\":\"N\",\"lvMax\":20}]";
	private static final Rarity rare1 = new Rarity(1, "N", 20);

	private static final String MOCK_STORE_OBJECT2 = "{\"rId\":2,\"name\":\"R\",\"lvMax\":40}";
	private static final Rarity rare2 = new Rarity(2, "R", 40);

	private static final String MOCK_STORE_OBJECT3 = "{\"rId\":3,\"name\":\"SR\",\"lvMax\":60}";
	private static final Rarity rare3 = new Rarity(3, "SR", 60);

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);

	}

	@Test
	public void getAllRarities() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Rarity> rarity = new ArrayList<>();
		rarity.add(rare1);
		Mockito.when(query.getResultList()).thenReturn(rarity);
		Assert.assertEquals(MOCK_STORE_DATA_ARRAY1, repo.getAllRarity());
	}

	@Test
	public void getEmptyUsers() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Rarity> rarity = new ArrayList<>();

		Assert.assertEquals(0, rarity.size());

		Assert.assertEquals("{\"Message\": \"Table empty\"}", repo.getAllRarity());

	}

	@Test
	public void getIdExist() {
		List<Rarity> rarity = new ArrayList<>();

		rarity.add(rare1);
		rarity.add(rare2);

		Mockito.when(manager.find(Rarity.class, 2)).thenReturn(rare2);

		Assert.assertEquals(2, rarity.size());
		Assert.assertEquals(MOCK_STORE_OBJECT2, repo.getRarityId(2));
	}

	@Test
	public void getIdFail() {
		List<Rarity> rarity = new ArrayList<>();

		rarity.add(rare1);
		rarity.add(rare2);

		Mockito.when(manager.find(Rarity.class, 2)).thenReturn(rare2);

		Assert.assertEquals(2, rarity.size());
		Assert.assertEquals("{\"Message\": \"Desired Rarity Doesn't Exist\"}", repo.getRarityId(3));
	}

	@Test
	public void getNameSingle() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Rarity> rarity = new ArrayList<>();

		rarity.add(rare1);
		rarity.add(rare2);
		Mockito.when(query.getResultList()).thenReturn(rarity);

		Assert.assertEquals(2, rarity.size());
		Assert.assertEquals(MOCK_STORE_DATA_ARRAY1, repo.getRarityName("N"));

	}

	@Test
	public void getNameMulti() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Rarity> rarity = new ArrayList<>();

		rarity.add(rare1);
		rarity.add(rare2);
		rarity.add(rare3);

		Mockito.when(query.getResultList()).thenReturn(rarity);

		Assert.assertEquals(3, rarity.size());
		Assert.assertEquals("[" + MOCK_STORE_OBJECT2 + "," + MOCK_STORE_OBJECT3 + "]", repo.getRarityName("R"));

	}

	@Test
	public void getNameNothing() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Rarity> rarity = new ArrayList<>();

		rarity.add(rare1);
		rarity.add(rare2);
		Mockito.when(query.getResultList()).thenReturn(rarity);

		Assert.assertEquals(2, rarity.size());
		Assert.assertEquals("{\"message\": \"Searched rarity does not exist\"}", repo.getRarityName("z"));

	}

}
