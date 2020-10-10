package com.ivione93;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.logging.Logger;

import com.ivione93.service.TeamService;

@RequestScoped
@Path("/myteam-api")
public class TeamResource {
	
	private static final Logger log = Logger.getLogger(TeamResource.class);
	
	@Inject
	TeamService teamService;
    
    @GET
    @Path("/atletas")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Query for current athletes", description = "Get all athletes")
    public Response getAllAthletes() {
    	
    	log.info("Request all athletes");
    	
    	String responseAthletes = teamService.getAllAthletes();
    	
    	return Response.ok(responseAthletes).build();
    }
    
    @GET
    @Path("/atletas/{licencia}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Query an athlete by licencia", description = "Get an athlete by licencia")
    public Response getAthleteByLicencia(@PathParam("licencia") String licencia) {
    	
    	log.infof("Request an athlete with licencia %s", licencia);
    	
    	String responseAthlete = teamService.getAthleteByLicencia(licencia);
    	
    	return Response.ok(responseAthlete).build();
    }
}