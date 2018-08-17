package com.disney.poc.profile.jedispoc.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public interface RestPreferenceService {

	@GET
	@Path("/{id}/preference")
	@Produces({MediaType.APPLICATION_JSON})
	Response getPreference(@PathParam("id") String id);
	
	@DELETE
	@Path("/{id}/preference")
	@Produces({MediaType.APPLICATION_JSON})
	Response deletePreference(@PathParam("id") String id);
	
	@DELETE
	@Path("/preference")
	@Produces({MediaType.APPLICATION_JSON})
	Response deletePreference();
}
