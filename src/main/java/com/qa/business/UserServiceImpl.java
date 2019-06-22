package com.qa.business;

import javax.inject.Inject;

import com.qa.persistance.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
	@Inject
	private UserRepository repo;

	
	public String createUser(String user) {
		
		return repo.createUser(user);
	}

	
	public String findAllUsers() {
		
		return repo.findAllUsers();
	}

	
	public String findAUserId(int id) {
		
		return repo.findAUserId(id);
	}

	
	public String findAUserName(String username) {
		
		return repo.findAUserName(username);
	}

	
	public String updateUser(int id, String user) {
		
		return repo.updateUser(id, user);
	}

	
	public String deleteUser(int id) {
		
		return repo.deleteUser(id);
	}


	
	public String findAUserNameExact(String username) {
		
		return repo.findAUserNameExact(username);
	}

	
}
