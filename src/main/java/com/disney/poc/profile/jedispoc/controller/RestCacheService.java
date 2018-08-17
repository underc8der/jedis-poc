package com.disney.poc.profile.jedispoc.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin/caches")
public interface RestCacheService {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response listCache();
	
	@DELETE
	@Path("/{cacheName}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response deleteCache(@PathParam("cacheName") String cacheName);
	
}
