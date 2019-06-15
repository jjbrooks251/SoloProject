package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.RarityService;

@Path("/Rarity")
public class RarityControl {

	@Inject
	private RarityService service;

	@Path("/getAllRarity")
	@GET
	@Produces({ "application/json" })
	public String getAllRarity() {
		return service.getAllRarity();
	}

	@Path("/getRarityId/{rId}")
	@GET
	@Produces({ "application/json" })
	public String getRarityId(@PathParam("rId") int rId) {
		return service.getRarityId(rId);
	}
	
	@Path("/getRarityName/{name}")
	@GET
	@Produces({ "application/json" })
	public int getRarityName(@PathParam("name") String name) {
		return service.getRarityName(name);
	}

}
