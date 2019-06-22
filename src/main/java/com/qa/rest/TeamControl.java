package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.TeamService;

@Path("/Team")
public class TeamControl {

	@Inject
	private TeamService service;

	@Path("/findAllTeams")
	@GET
	@Produces({ "application/json" })
	public String findAllTeams() {
		return service.findAllTeams();
	}

	@Path("/findATeamName/{teamname}")
	@GET
	@Produces({ "application/json" })
	public String findATeamName(@PathParam("teamname") String teamname) {
		return service.findATeamName(teamname);
	}
	
	@Path("/createTeam")
	@POST
	@Produces({ "application/json" })
	public String createTeam(String team) {
		return service.createTeam(team);
	}

	@Path("/deleteTeam/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTeam(@PathParam("id") int id) {
		return service.deleteTeam(id);
	}

	@Path("/updateTeam/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTeam(@PathParam("id") int id, String team) {
		return service.updateTeam(id, team);
	}
	
	@Path("/findATeamUser/{id}")
	@GET
	@Produces({ "application/json" })
	public String findATeamUser(@PathParam("id") int id) {
		return service.findATeamUser(id);
	}
	
	@Path("/getTeamUnits/{tId}")
	@GET
	@Produces({ "application/json" })
	public String getTeamUnits(@PathParam("tId") int tId) {
		return service.getTeamUnits(tId);
	}
}
