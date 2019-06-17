package com.qa.business;

import javax.inject.Inject;

import com.qa.persistance.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
	@Inject
	private UserRepository repo;

	
	public String createUser(String user) {
		// TODO Auto-generated method stub
		return repo.createUser(user);
	}

	
	public String findAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAllUsers();
	}

	
	public String findAUserId(int id) {
		// TODO Auto-generated method stub
		return repo.findAUserId(id);
	}

	
	public String findAUserName(String username) {
		// TODO Auto-generated method stub
		return repo.findAUserName(username);
	}

	
	public String updateUser(int id, String user) {
		// TODO Auto-generated method stub
		return repo.updateUser(id, user);
	}

	
	public String deleteUser(int id) {
		// TODO Auto-generated method stub
		return repo.deleteUser(id);
	}

	
}
