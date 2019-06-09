package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
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
	
	

}
