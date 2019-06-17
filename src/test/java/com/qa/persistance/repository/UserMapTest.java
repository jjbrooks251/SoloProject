package com.qa.persistance.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistance.repository.UserMapRepository;
import com.qa.util.JSONUtil;

public class UserMapTest {

	private JSONUtil util;
	private UserMapRepository ump;

	@Before
	public void setup() {
		util = new JSONUtil();
		ump = new UserMapRepository();

	}

	@Test
	public void createUser() {

		assertEquals(0, ump.getUserMap().size());

		ump.createUser(Constants.user1);

		assertEquals(1, ump.getUserMap().size());
	}

	@Test
	public void getEmptyMap() {

		assertEquals(0, ump.getUserMap().size());
		assertEquals("{\"message\": \"Map of Users is empty\"}", ump.findAllUsers());

	}

	@Test
	public void getAllUsers() {

		ump.createUser(Constants.user1);
		assertEquals(1, ump.getUserMap().size());
	}

	@Test
	public void getAUser() {

		ump.createUser(Constants.user1);
		assertEquals("User: 1, jbro95, Jbrooks95, jbro95@qa.com, []", ump.findAUserId(1));
	}

	@Test
	public void getUserNotExist() {

		assertEquals("{\"message\": \"User does not exist\"}", ump.findAUserId(1));

	}

	@Test
	public void create2Users() {

		ump.createUser(Constants.user1);
		ump.createUser(Constants.user2);

		assertEquals(2, ump.getUserMap().size());

	}

	@Test
	public void createUserSameId() {
		
		ump.createUser(Constants.user1);
		
		
		assertEquals("{\"message\": \"Conflicting User Id\"}", ump.createUser(Constants.sameId));

	}

	@Test
	public void deleteUser() {

		ump.createUser(Constants.user1);
		assertEquals(1, ump.getUserMap().size());
		
		ump.deleteUser(1);
		
		assertEquals(0, ump.getUserMap().size());
		
	}

	@Test
	public void deleteDoesntExist() {

		assertEquals("{\"Message\": \"Account does not exist\"}", ump.deleteUser(1));
		
	}

	@Test
	public void updateUser() {

		ump.createUser(Constants.user1);
		
		assertEquals("User: 1, jbro95, Jbrooks95, jbro95@qa.com, []", ump.findAUserId(1));
		
		ump.updateUser(1, Constants.sameId);
		
		assertEquals("User: 1, jbro951, Jbrooks95, jbrok95@qa.com, []", ump.findAUserId(1));
		
	}

	@Test
	public void updateDoesntExist() {

		assertEquals(0, ump.getUserMap().size());
		
		assertEquals("{\"message\": \"User does not exist\"}", ump.updateUser(1, Constants.user1));
		
	}

}
