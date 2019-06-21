package com.qa.persistance.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class UserDBTest {

	// descirbes the class under test
	@InjectMocks
	private UserDatabaseRepository repo;

	// Mock gives us what the test requires
	@Mock
	private EntityManager manager;

	private JSONUtil util;

	@Mock
	private Query query;

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
		
	}

	@Test
	public void getAllUsers() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<>();
		users.add(Constants.user11);
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals(Constants.MOCK_USER_DATA_ARRAY1, repo.findAllUsers());

	}

	@Test
	public void getEmptyUsers() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<>();

		Assert.assertEquals(0, users.size());

		Assert.assertEquals("{\"message\": \"User Field is empty\"}", repo.findAllUsers());

	}

	@Test
	public void getIdExist() {
		List<User> users = new ArrayList<>();

		users.add(Constants.user11);
		users.add(Constants.user12);

		Mockito.when(manager.find(User.class, 2)).thenReturn(Constants.user12);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals(Constants.MOCK_USER_OBJECT2, repo.findAUserId(2));
	}

	@Test
	public void getIdFail() {
		List<User> users = new ArrayList<>();

		users.add(Constants.user11);
		users.add(Constants.user12);

		Mockito.when(manager.find(User.class, 2)).thenReturn(Constants.user13);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User doesn't exist\"}", repo.findAUserId(3));

	}

	@Test
	public void getNameSingle() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<User> users = new ArrayList<>();

		users.add(Constants.user11);
		users.add(Constants.user12);

		Mockito.when(query.getResultList()).thenReturn(users);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals(Constants.MOCK_USER_DATA_ARRAY1, repo.findAUserName("j"));

	}

	@Test
	public void getNameMulti() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<User> users = new ArrayList<>();

		final User user11 = new User(1, "jbro95", "Jbrooks95", "jbro95@qa.com", null);
		final User user12 = new User(2, "cTatum94", "Mynamegeoff25", "cTatum94@qa.com", null);
		final User user13 = new User(3, "jbro951", "Jbrooks951", "jbrok951@qa.com", null);
		
		users.add(user11);
		users.add(user12);
		users.add(user13);

		Mockito.when(query.getResultList()).thenReturn(users);

		Assert.assertEquals(3, users.size());
		Assert.assertEquals("[" + Constants.MOCK_USER_OBJECT1 + "," + Constants.MOCK_USER_OBJECT3 + "]", repo.findAUserName("j"));

	}

	@Test
	public void getNameNothing() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<>();

		users.add(Constants.user11);
		users.add(Constants.user12);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User does not exist\"}", repo.findAUserName("z"));

	}

	@Test
	public void createUser() {
	
		Assert.assertEquals("{\"message\": \"New User Created\"}", repo.createUser(Constants.MOCK_USER_OBJECT2));
		
	}

	@Test
	public void deleteUser() {
		List<User> users = new ArrayList<>();

		users.add(Constants.user11);
		users.add(Constants.user12);

		Mockito.when(manager.find(User.class, 2)).thenReturn(Constants.user12);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User Deleted\"}", repo.deleteUser(2));

	}

	@Test
	public void deleteFail() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<>();

		users.add(Constants.user11);
		users.add(Constants.user12);

		Mockito.when(manager.find(User.class, 2)).thenReturn(Constants.user12);
	
		Mockito.when(query.getResultList()).thenReturn(users);
		
		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User with this id doesn't exist\"}", repo.deleteUser(3));
	}

	@Test
	public void updateUser() {
		List<User> users = new ArrayList<>();

		users.add(Constants.user11);
		users.add(Constants.user12);

		Mockito.when(manager.find(User.class, 2)).thenReturn(Constants.user12);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User Updated\"}", repo.updateUser(2, Constants.MOCK_USER_OBJECT3));
		Assert.assertEquals("{\"uId\":2,\"username\":\"jbro951\",\"password\":\"Jbrooks951\",\"email\":\"jbrok951@qa.com\"}", repo.findAUserId(2));

	}

	@Test
	public void updateFail() {

		List<User> users = new ArrayList<>();

		users.add(Constants.user11);
		users.add(Constants.user12);

		Mockito.when(manager.find(User.class, 2)).thenReturn(Constants.user12);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User does not exist\"}", repo.updateUser(3, Constants.MOCK_USER_OBJECT3));
	}
	
	@Test
	public void findAUserNameExact() {

		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<User> users = new ArrayList<>();

		users.add(Constants.user11);
		users.add(Constants.user12);

		Mockito.when(query.getResultList()).thenReturn(users);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals(Constants.MOCK_USER_DATA_ARRAY1, repo.findAUserNameExact("jbro95"));
	}
	
	@Test
	public void findAUserNameExactFail() {

		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<User> users = new ArrayList<>();

		users.add(Constants.user11);
		users.add(Constants.user12);

		Mockito.when(query.getResultList()).thenReturn(users);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User does not exist\"}", repo.findAUserNameExact("jb"));
	}

}
