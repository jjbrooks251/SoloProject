package com.qa.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.UserServiceImpl;
import com.qa.persistance.repository.Constants;

@RunWith(MockitoJUnitRunner.class)
public class UserRestTest {

	@InjectMocks
	public UserControl control;
	
	@Mock
	private UserServiceImpl service;

	@Before
	public void setup() {
		
	}
	
	@Test
	public void createUser() {
		Mockito.when(service.createUser(Constants.MOCK_USER_OBJECT3)).thenReturn("{\"message\": \"New User Created\"}");
		Assert.assertEquals("{\"message\": \"New User Created\"}", control.createUser(Constants.MOCK_USER_OBJECT3));
	
	}
	
	@Test
	public void findAllUsers() {
		Mockito.when(service.findAllUsers()).thenReturn("{\"message\": \"User Field is empty\"}");
		Assert.assertEquals("{\"message\": \"User Field is empty\"}", control.findAllUsers());
	
	}
	
	@Test
	public void findAUserId() {
		Mockito.when(service.findAUserId(1)).thenReturn(Constants.MOCK_USER_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_USER_DATA_ARRAY1, control.findAUserId(1));
	
	}
	
	@Test
	public void updateUser() {
		Mockito.when(service.updateUser(1, Constants.MOCK_USER_OBJECT3)).thenReturn("{\"message\": \"User Updated\"}");
		Assert.assertEquals("{\"message\": \"User Updated\"}", control.updateUser(1, Constants.MOCK_USER_OBJECT3));
	
	}
	
	@Test
	public void deleteUser() {
		Mockito.when(service.deleteUser(1)).thenReturn("{\"message\": \"User Deleted\"}");
		Assert.assertEquals("{\"message\": \"User Deleted\"}", control.deleteUser(1));
	
	}
	
	@Test
	public void findAUserName() {
		Mockito.when(service.findAUserName("j")).thenReturn(Constants.MOCK_USER_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_USER_DATA_ARRAY1, control.findAUserName("j"));
	
	}
	
	@Test
	public void findAUserNameExact() {
		Mockito.when(service.findAUserNameExact("jbro95")).thenReturn(Constants.MOCK_USER_DATA_ARRAY1);
		Assert.assertEquals(Constants.MOCK_USER_DATA_ARRAY1, control.findAUserNameExact("jbro95"));
	}
}
