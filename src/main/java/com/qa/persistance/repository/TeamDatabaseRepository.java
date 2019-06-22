package com.qa.persistance.repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistance.domain.Team;
import com.qa.persistance.domain.Unit;
import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class TeamDatabaseRepository implements TeamRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	
	public String createTeam(String team) {
	
		return null;
	}

	
	public String findAllTeams() {
		Query query = manager.createQuery("SELECT t FROM Team t");

		Collection<Team> teams = (Collection<Team>) query.getResultList();

		return util.getJSONForObject(teams);
	}

	
	public String findATeamId(int id) {
		
		return null;
	}

	
	public String findATeamName(String name) {
		
		Query query = manager.createQuery("SELECT t FROM Team t");

		Collection<Team> teams = (Collection<Team>) query.getResultList();

		List<Team> result = teams.stream().filter(n -> n.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());

		if (result.isEmpty()) {

			return "{\"message\": \"Searched Team does not exist\"}";

		} else {
			return util.getJSONForObject(result);
		}
	}

	
	public String updateTeam(int id, String team) {
		
		return null;
	}

	
	public String deleteTeam(int id) {
		
		return null;
	}
	
	

}
