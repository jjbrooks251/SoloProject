package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.StorageService;

@Path("/Storage")
public class StorageControl {

	@Inject
	StorageService service; 
	
	@Path("/getStore/{uId}/{cId}")
	@GET
	@Produces({ "application/json" })
	public String findAStorageId(@PathParam("uId")int uId, @PathParam("cId") int cId) {
		return service.findAStorageId(uId, cId);
	}
	
	@Path("/deleteStore/{uId}/{cId}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteStorage(@PathParam("uId")int uId, @PathParam("cId") int cId) {
		return service.deleteStorage(uId, cId);
	}
	
}
