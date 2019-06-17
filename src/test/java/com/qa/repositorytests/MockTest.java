package com.qa.repositorytests;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistance.repository.UserDatabaseRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {
	
	//descirbes the class under test
	@InjectMocks 
	private UserDatabaseRepository repo; 
	
	//Mock gives us what the test requires
	@Mock
	private EntityManager manager; 
	
	@Mock
	private JSONUtil util; 
	
	@Mock
	private Query query;
	
	private static final String MOCK_DATA_ARRAY = "[\"title\": ]";
	private static final String MOCK_OBJECT = "{\"title\":\ }";
	
	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
		
	}
	
	@Test
	private void tewst1() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		
	}
	

	
	
}
