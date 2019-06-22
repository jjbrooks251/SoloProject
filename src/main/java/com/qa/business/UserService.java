package com.qa.business;

public interface UserService {

	public String createUser(String user);
	
	public String findAllUsers();
	
	public String findAUserId(int id);
	
	public String updateUser(int id, String user);
	
	public String deleteUser(int id);
	
	public String findAUserName(String username);
	
	public String findAUserNameExact(String username);
}
