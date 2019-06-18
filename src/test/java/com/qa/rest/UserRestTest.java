package com.qa.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserRestTest {

	@InjectMocks
	public UserControl control;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void createUser() {
		Assert.assertEquals(1, 1);
	}
	
	@Ignore
	public void findAllUsers() {
		
	}
	
	@Ignore
	public void findAUserId() {
		
	}
	
	@Ignore
	public void updateUser() {
		
	}
	
	@Ignore
	public void deleteUser() {
		
	}
	
	@Ignore
	public void findAUserName() {
		
	}
}
