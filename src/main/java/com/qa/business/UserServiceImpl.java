package com.qa.business;

import javax.inject.Inject;

import com.qa.persistance.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
	@Inject
	private UserRepository repo;

	@Override
	public String createUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findAUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(int id, String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
