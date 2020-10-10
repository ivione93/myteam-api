package com.ivione93.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@RequestScoped
public class TeamService {
	
	private static final Logger log = Logger.getLogger(TeamService.class);
	
	@Inject
	@RestClient
	DataService dataService;
	
	public String getAllAthletes() {
		log.info("[API] Service getAllAthletes method");
		
		Response response = dataService.getAllAthletes();
		
		String receivedAthletes = response.readEntity(String.class);
		
		return receivedAthletes;
	}
	
	public String getAthleteByLicencia(String licencia) {
		log.infof("[API] Service getAthleteByLicencia method with parameter { licencia: %s }", licencia);
		
		Response response = dataService.getAthleteByLicencia(licencia);
		
		String receivedAthlete = response.readEntity(String.class);
		
		return receivedAthlete;
	}

}
