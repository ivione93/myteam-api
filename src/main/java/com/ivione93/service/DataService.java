package com.ivione93.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/myteam-data")
@RegisterRestClient(configKey="myteam-data")
public interface DataService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/atletas")
	public Response getAllAthletes();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/atletas/{licencia}")
	public Response getAthleteByLicencia(@PathParam("licencia") String licencia);
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/atletas/{licencia}/results")
    public Response getAthleteResults(@PathParam("licencia") String licencia);

}
