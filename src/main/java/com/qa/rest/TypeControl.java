package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.TypeService;

@Path("/Type")
public class TypeControl {

	@Inject
	TypeService service;
	
	@Path("/getAllTypes")
	@GET
	@Produces({ "application/json" })
	public String getAllTypes() {
		return service.getAllTypes();
	}
	
	@Path("/getTypeId/{tId}")
	@GET
	@Produces({ "application/json" })
	public String getTypeId(@PathParam("tId") int tId) {
		return service.getTypeId(tId);
	}
	
	@Path("/getTypeName/{name}")
	@GET
	@Produces({ "application/json" })
	public String getTypeName(@PathParam("name") String name) {
		return service.getTypeName(name);
	}
	
}
