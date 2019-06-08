package com.qa.business;

public interface UserService {

	public String createUser(String user);
	
	public String findAllUsers();
	
	public String findAUser(int id);
	
	public String updateUser(int id, String user);
	
	public String deleteUser(int id);
	
}
