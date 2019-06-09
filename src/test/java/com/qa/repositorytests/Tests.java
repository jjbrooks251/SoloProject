package com.qa.repositorytests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistance.domain.User;
import com.qa.persistance.repository.UserMapRepository;
import com.qa.util.JSONUtil;

public class Tests {

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
		assertEquals("User: 1, jbro95, Jbrooks95, jbro95@qa.com", ump.findAUserId(1));
	}

	@Test
	public void getUserNotExist() {

		assertEquals("User does not exist", ump.findAUserId(1));

	}

	@Test
	public void create2Users() {

		ump.createUser(Constants.user1);
		ump.createUser(Constants.user2);

		assertEquals(2, ump.getUserMap().size());

	}

	@Test
	public void getMultipleUsers() {
		ump.createUser(Constants.user1);
		ump.createUser(Constants.user2);
		ump.createUser(Constants.user3);

		assertEquals(2, ump.findAUserName("jbro95"));
	}

	@Test
	public void createUserSameId() {
		
		ump.createUser(Constants.user1);
		
		
		assertEquals("{\"message\": \"Conflicting User Id\"}", ump.createUser(Constants.sameId));

	}

	@Ignore
	public void createUserSameName() {

	}

	@Ignore
	public void createUserSameEmail() {

	}

	@Ignore
	public void createMissingInfo() {

	}

	@Ignore
	public void createSmallPassword() {

	}

	@Ignore
	public void createPasswordNoNumber() {

	}

	@Ignore
	public void createPasswordNoUpper() {

	}

	@Ignore
	public void createPasswordNoLower() {

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

	@Ignore
	public void updateUser() {

	}

	@Ignore
	public void updateDoesntExist() {

	}

	@Ignore
	public void updateUserSameName() {

	}

	@Ignore
	public void updateUserSameEmail() {

	}

	@Ignore
	public void updateMissingInfo() {

	}

	@Ignore
	public void updateSmallPassword() {

	}

	@Ignore
	public void updatePasswordNoNumber() {

	}

	@Ignore
	public void updatePasswordNoUpper() {

	}

	@Ignore
	public void updatePasswordNoLower() {

	}

}
