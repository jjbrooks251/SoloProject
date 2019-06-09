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
	public void getEmptyMap() {

		assertEquals(0, ump.getUserMap().size());
		assertEquals("{\"message\": \"Map of Users is empty\"}", ump.findAllUsers());

	}

	@Test
	public void getAllUsers() {

		ump.getUserMap().put(1, Constants.user1);
		assertEquals(1, ump.getUserMap().size());
	}

	@Ignore
	public void getAUser() {

	}

	@Ignore
	public void getUserNotExist() {

	}

	@Ignore
	public void getMultipleUsers() {

	}

	@Ignore
	public void createUser() {

	}

	@Ignore
	public void create2Users() {

	}

	@Ignore
	public void createUserSameId() {

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

	@Ignore
	public void deleteUser() {

	}

	@Ignore
	public void deleteDoesntExist() {

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
