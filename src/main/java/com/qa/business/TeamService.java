package com.qa.business;

public interface TeamService {

	public String createTeams(String team);
	
	public String findAllTeams();

	public String findATeamId(int id);

	public int findATeamName(String team);

	public String updateTeam(int id, String team);

	public String deleteTeam(int id);

}
