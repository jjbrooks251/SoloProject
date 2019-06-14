package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.UserService;
import com.qa.persistance.repository.TeamRepository;
@Path("/Team")
public class TeamControl {

	@Inject
	private TeamRepository service;

	@Path("/findAllTeams")
	@GET
	@Produces({ "application/json" })
	public String findAllUsers() {
		return service.findAllTeams();
	}
	
}
