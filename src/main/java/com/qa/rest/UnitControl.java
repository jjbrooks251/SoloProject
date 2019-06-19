package com.qa.rest;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.UnitService;

@Path("/Unit")
public class UnitControl {

	@Inject
	UnitService service; 
	
	@Path("/getAllUnits")
	@GET
	@Produces({ "application/json" })
	public String getAllUnits() {
		return service.getAllUnits();
	}
	
	@Path("/getUnitId/{cId}")
	@GET
	@Produces({ "application/json" })
	public String getUnitId(@PathParam("cId") int cId) {
		return service.getUnitId(cId);
	}
	
	@Path("/getUnitName/{name}")
	@GET
	@Produces({ "application/json" })
	public String getUnitName(@PathParam("name") String name) {
		return service.getUnitName(name);
	}
	
}
