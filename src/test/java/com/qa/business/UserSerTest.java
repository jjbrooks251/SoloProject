package com.qa.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistance.repository.Constants;
import com.qa.persistance.repository.UserDatabaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserSerTest {

	@InjectMocks
	private UserServiceImpl service;

	@Mock
	private UserDatabaseRepository repo;

	@Before
	public void setup() {

	}

	@Test
	public void createUser() {
		Mockito.when(repo.createUser(Constants.MOCK_USER_OBJECT3)).thenReturn("{\"message\": \"New User Created\"}");
		Assert.assertEquals("{\"message\": \"New User Created\"}", service.createUser(Constants.MOCK_USER_OBJECT3));
	}

	@Test
	public void findAllUsers() {
		Mockito.when(repo.findAllUsers()).thenReturn("{\"message\": \"User Field is empty\"}");
		Assert.assertEquals("{\"message\": \"User Field is empty\"}", service.findAllUsers());
	}

	@Test
	public void findAUserId() {
		Mockito.when(repo.findAUserId(1)).thenReturn(Constants.MOCK_USER_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_USER_DATA_ARRAY1, service.findAUserId(1));
	}

	@Test
	public void updateUser() {
		Mockito.when(repo.updateUser(1, Constants.MOCK_USER_OBJECT3)).thenReturn("{\"message\": \"User Updated\"}");
		Assert.assertEquals("{\"message\": \"User Updated\"}", service.updateUser(1, Constants.MOCK_USER_OBJECT3));
	}

	@Test
	public void deleteUser() {
		Mockito.when(repo.deleteUser(1)).thenReturn("{\"message\": \"User Deleted\"}");
		Assert.assertEquals("{\"message\": \"User Deleted\"}", service.deleteUser(1));
	}

	@Test
	public void findAUserName() {
		Mockito.when(repo.findAUserName("j")).thenReturn(Constants.MOCK_USER_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_USER_DATA_ARRAY1, service.findAUserName("j"));
	}
	
	@Test
	public void findAUserNameExact() {
		Mockito.when(repo.findAUserNameExact("jbro95")).thenReturn(Constants.MOCK_USER_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_USER_DATA_ARRAY1, service.findAUserNameExact("jbro95"));
	}
}
