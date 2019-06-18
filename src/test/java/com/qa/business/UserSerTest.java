package com.qa.business;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistance.domain.User;

@RunWith(MockitoJUnitRunner.class)
public class UserSerTest {

	@InjectMocks
	private UserServiceImpl service;
	
	private static final String MOCK_DATA_ARRAY1 = "[{\"uId\":1,\"username\":\"jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\"}]";
	private static final String MOCK_OBJECT1 = "{\"uId\":1,\"username\":\"jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\"}";
	
	private static final String MOCK_DATA_ARRAY2 = "[{\"uId\":2,\"username\":\"cTatum94\",\"password\":\"Mynamegeoff25\",\"email\":\"cTatum94@qa.com\"}]";
	private static final String MOCK_OBJECT2 = "{\"uId\":2,\"username\":\"cTatum94\",\"password\":\"Mynamegeoff25\",\"email\":\"cTatum94@qa.com\"}";
	
	private static final String MOCK_DATA_ARRAY3 = "[{\"uId\":3,\"username\":\"jbro951\",\"password\":\"Jbrooks95\",\"email\":\"jbrok951@qa.com\"}]";
	private static final String MOCK_OBJECT3 = "{\"uId\":3,\"username\":\"jbro951\",\"password\":\"Jbrooks95\",\"email\":\"jbrok951@qa.com\"}";
	
	private static final User user1 = new User(1, "jbro95", "Jbrooks95", "jbro95@qa.com", null);
	private static final User user2 = new User(2, "cTatum94", "Mynamegeoff25", "cTatum94@qa.com", null);
	private static final User user3 = new User(3, "jbro951", "Jbrooks95", "jbrok951@qa.com", null);

	
	@Before
	public void setup() {
		
	}
	
	@Ignore
	private void createUser() {
		
	}
	
	@Ignore
	private void findAllUsers() {
		
	}
	
	@Ignore
	private void findAUserId() {
		
	}
	
	@Ignore
	private void updateUser() {
		
	}
	
	@Ignore
	private void deleteUser() {
		
	}
	
	@Ignore
	private void findAUserName() {
		
	}
}
