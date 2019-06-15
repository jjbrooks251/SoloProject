package com.qa.rest;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.CharacterService;

@Path("/Character")
public class CharacterControl {

	@Inject
	CharacterService service; 
	
	@Path("/getAllCharacters")
	@GET
	@Produces({ "application/json" })
	public String getAllCharacters() {
		return service.getAllCharacters();
	}
	
	@Path("/getCharId/{cId}")
	@GET
	@Produces({ "application/json" })
	public String getCharId(@PathParam("cId") int cId) {
		return service.getCharId(cId);
	}
	
	@Path("/getCharName/{name}")
	@GET
	@Produces({ "application/json" })
	public int getCharName(@PathParam("name") String name) {
		return service.getCharName(name);
	}
	
	
	
	
	
}
