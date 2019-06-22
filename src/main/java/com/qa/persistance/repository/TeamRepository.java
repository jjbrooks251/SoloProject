package com.qa.persistance.repository;

public interface TeamRepository {

	public String createTeam(String team);
	
	public String findAllTeams();
	
	public String findATeamName(String name);
	
	public String updateTeam(int id, String team);
	
	public String deleteTeam(int id);
	
}
