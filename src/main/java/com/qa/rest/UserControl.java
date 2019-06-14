package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@Path("/findAUserId/{id}")
	@GET
	@Produces({ "application/json" })
	public String findAUserId(@PathParam("id") int id) {
		return service.findAUserId(id);
	}
	
	@Path("/findAUserName/{username}")
	@GET
	@Produces({ "application/json" })
	public int findAUserName(@PathParam("username") String username) {
		return service.findAUserName(username);
	}
	
	@Path("/createUser")
	@POST
	@Produces({ "application/json" })
	public String createUser(String username) {
		return service.createUser(username);
	}
	
	@Path("/deleteUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("id") int id) {
		return service.deleteUser(id);
	}
	
	@Path("/updateUser/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("id") int id, String username) {
		return service.updateUser(id, username);
	}
	
}
