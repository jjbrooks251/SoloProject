package com.qa.persistance.repository;

public interface UserRepository {

	public String createUser(String user);
	
	public String findAllUsers();
	
	public String findAUser(int id);
	
	public String updateUser(int id, String user);
	
	public String deleteUser(int id);
	
}
