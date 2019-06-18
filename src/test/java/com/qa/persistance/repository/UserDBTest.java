package com.qa.persistance.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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

	private static final String MOCK_DATA_ARRAY1 = "[{\"uId\":1,\"username\":\"jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\"}]";
	private static final String MOCK_OBJECT1 = "{\"uId\":1,\"username\":\"jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\"}";
	private static final User user1 = new User(1, "jbro95", "Jbrooks95", "jbro95@qa.com", null);

	private static final String MOCK_DATA_ARRAY2 = "[{\"uId\":2,\"username\":\"cTatum94\",\"password\":\"Mynamegeoff25\",\"email\":\"cTatum94@qa.com\"}]";
	private static final String MOCK_OBJECT2 = "{\"uId\":2,\"username\":\"cTatum94\",\"password\":\"Mynamegeoff25\",\"email\":\"cTatum94@qa.com\"}";
	private static final User user2 = new User(2, "cTatum94", "Mynamegeoff25", "cTatum94@qa.com", null);

	private static final String MOCK_DATA_ARRAY3 = "[{\"uId\":3,\"username\":\"jbro951\",\"password\":\"Jbrooks95\",\"email\":\"jbrok951@qa.com\"}]";
	private static final String MOCK_OBJECT3 = "{\"uId\":3,\"username\":\"jbro951\",\"password\":\"Jbrooks95\",\"email\":\"jbrok951@qa.com\"}";
	private static final User user3 = new User(3, "jbro951", "Jbrooks95", "jbrok951@qa.com", null);

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
		users.add(user1);
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals(MOCK_DATA_ARRAY1, repo.findAllUsers());

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
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);

		Mockito.when(manager.find(User.class, 2)).thenReturn(user2);

		System.out.println(repo.findAllUsers());
		Assert.assertEquals(2, users.size());
		Assert.assertEquals(MOCK_OBJECT2, repo.findAUserId(2));
	}

	@Ignore
	public void getIdFail() {
		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);

		Mockito.when(manager.find(User.class, 2)).thenReturn(user3);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User doesn't exist\"}", repo.findAUserId(3));

	}

	@Test
	public void getNameSingle() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);

		Mockito.when(query.getResultList()).thenReturn(users);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals(MOCK_DATA_ARRAY1, repo.findAUserName("j"));

	}

	@Test
	public void getNameMulti() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);
		users.add(user3);

		Mockito.when(query.getResultList()).thenReturn(users);

		Assert.assertEquals(3, users.size());
		Assert.assertEquals("[" + MOCK_OBJECT1 + "," + MOCK_OBJECT3 + "]", repo.findAUserName("j"));

	}

	@Test
	public void getNameNothing() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User does not exist\"}", repo.findAUserName("z"));

	}

	@Ignore
	public void createUser() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<>();
		Mockito.when(query.getResultList()).thenReturn(users);

		//User user4 = new User(2, "cTatum94", "Mynamegeoff25", "cTatum94@qa.com", null);
		// Mockito.when(manager.persist(user4));

		Assert.assertEquals("{\"message\": \"New User Created\"}", repo.createUser(MOCK_OBJECT2));
		Assert.assertEquals(MOCK_DATA_ARRAY2, repo.findAllUsers());
	}

	@Ignore
	public void deleteUser() {

		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);

		Mockito.when(manager.find(User.class, 2)).thenReturn(user2);
	//	Mockito.when(manager.remove(user2)).thenReturn("{\"message\": \"User Deleted\"}");

		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User Deleted\"}", repo.deleteUser(2));
		Assert.assertEquals(1, users.size());

	}

	@Ignore
	public void deleteFail() {
		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User with this id doesn't exist\"}", repo.deleteUser(3));
		Assert.assertEquals(2, users.size());
	}

	@Ignore
	public void updateUser() {
		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User Updated\"}", repo.updateUser(2, MOCK_OBJECT3));

	}

	@Ignore
	public void updateFail() {

		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);

		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User does not exist\"}", repo.updateUser(3, MOCK_OBJECT3));
	}

}
