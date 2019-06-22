package com.qa.business;

import javax.inject.Inject;

import com.qa.persistance.repository.TeamRepository;

public class TeamServiceImpl implements TeamService {

	@Inject
	TeamRepository repo;
	
	public String findAllTeams() {
		return repo.findAllTeams();
	}
	
	public String findATeamName(String team) {
		return repo.findATeamName(team);
	}
	
	public String updateTeam(int id, String team) {
		return repo.updateTeam(id, team);
	}

	public String deleteTeam(int id) {
		return repo.deleteTeam(id);
	}

	public String createTeam(String team) {
		return repo.createTeam(team);
	}

}
