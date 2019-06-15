package com.qa.persistance.repository;

public interface TeamRepository {

public String createTeam(String team);
	
	public String findAllTeams();
	
	public String findATeamId(int id);
	
	public int findATeamName(String team);
	
	public String updateTeam(int id, String team);
	
	public String deleteTeam(int id);
	
	
}