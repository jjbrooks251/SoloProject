package com.qa.persistance.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistance.repository.UserMapRepository;

public class UserMapTest {

	private UserMapRepository ump;

	@Before
	public void setup() {
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
		assertEquals("{\"1\":" + Constants.user1 +"}", ump.findAllUsers());
	}

	@Test
	public void getAUserId() {

		ump.createUser(Constants.user1);
		assertEquals("User: 1, jbro95, Jbrooks95, jbro95@qa.com, []", ump.findAUserId(1));
	}

	@Test
	public void getUserIdNotExist() {

		assertEquals("{\"message\": \"User does not exist\"}", ump.findAUserId(1));

	}

	@Test
	public void getUserNameOne() {
		ump.createUser(Constants.user1);
		ump.createUser(Constants.user2);
		
		assertEquals("[{\"hash\":1,\"key\":1,\"value\":" + Constants.user1 + "}]", ump.findAUserName("j"));
		
	}
	
	@Test
	public void getUserNameNone() {
		ump.createUser(Constants.user1);
		ump.createUser(Constants.user2);
		
		assertEquals("{\"message\": \"User does not exist\"}", ump.findAUserName("z"));
		
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

		assertEquals("{\"Message\": \"User does not exist\"}", ump.deleteUser(1));
		
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
