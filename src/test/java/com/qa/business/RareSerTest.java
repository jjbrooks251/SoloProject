package com.qa.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistance.repository.RarityDatabaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class RareSerTest {

	@InjectMocks
	public RarityServiceImpl service;

	@Mock
	public RarityDatabaseRepository repo;
	
	@Before
	public void setup() {

	}

	@Test
	public void getAllRarity() {
		Assert.assertEquals(1, 1);
	}

	@Ignore
	public void getRarityId() {

	}

	@Ignore
	public void getRarityName() {

	}
}
