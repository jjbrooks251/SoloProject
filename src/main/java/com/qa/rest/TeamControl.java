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
	
	@Path("/findATeamId/{id}")
	@GET
	@Produces({ "application/json" })
	public String findAUserId(@PathParam("id") int id) {
		return service.findATeamId(id);
	}
	
	@Path("/findATeamName/{teamname}")
	@GET
	@Produces({ "application/json" })
	public int findAUserName(@PathParam("teamname") String teamname) {
		return service.findATeamName(teamname);
	}
	
	@Path("/createTeam")
	@POST
	@Produces({ "application/json" })
	public String createUser(String team) {
		return service.createTeam(team);
	}
	
	@Path("/deleteTeam/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("id") int id) {
		return service.deleteTeam(id);
	}
	
	@Path("/updateTeam /{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("id") int id, String team) {
		return service.updateTeam(id, team);
	}
	
}
