package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.UserService;

@Path("/User")
public class UserControl {
	
	@Inject
	private UserService service;

	@Path("/findAllUsers")
	@GET
	@Produces({ "application/json" })
	public String findAllUsers() {
		return service.findAllUsers();
	}
	
	@Path("/findAUserId")
	@GET
	@Produces({ "application/json" })
	public String findAUserId() {
		return service.findAllUsers();
	}
	
	@Path("/findAUserName")
	@GET
	@Produces({ "application/json" })
	public int findAUserName(String username) {
		return service.findAUserName(username);
	}
	
	@Path("/createUser")
	@POST
	@Produces({ "application/json" })
	public String createUser(String username) {
		return service.createUser(username);
	}
	
	@Path("/deleteUser")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(int id) {
		return service.deleteUser(id);
	}
	
	@Path("/updateUser")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(int id, String username) {
		return service.updateUser(id, username);
	}
	
}
