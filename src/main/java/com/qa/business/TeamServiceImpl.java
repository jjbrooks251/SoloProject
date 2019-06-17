package com.qa.business;

import javax.inject.Inject;

import com.qa.persistance.repository.TeamRepository;

public class TeamServiceImpl implements TeamService {

	@Inject
	TeamRepository repo;

	@Override
	public String findAllTeams() {
		return repo.findAllTeams();
	}

	@Override
	public String findATeamId(int id) {
		return repo.findATeamId(id);
	}

	@Override
	public int findATeamName(String team) {
		return repo.findATeamName(team);
	}

	@Override
	public String updateTeam(int id, String team) {
		return repo.updateTeam(id, team);
	}

	@Override
	public String deleteTeam(int id) {
		return repo.deleteTeam(id);
	}

	@Override
	public String createTeams(String team) {
		return repo.createTeam(team);
	}

}
