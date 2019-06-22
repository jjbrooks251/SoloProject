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
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class TeamDatabaseRepository implements TeamRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Transactional(TxType.REQUIRED)
	public String createTeam(String team) {

		Team teams = util.getObjectForJSON(team, Team.class);

		manager.persist(teams);

		return "{\"message\": \"New Team has been Created\"}";
	}

	public String findAllTeams() {
		Query query = manager.createQuery("SELECT t FROM Team t");

		Collection<Team> teams = (Collection<Team>) query.getResultList();

		if (teams.isEmpty()) {
			return "{\"Message\": \"There are no teams to return\"}";
		} else {

			return util.getJSONForObject(teams);
		}
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

	@Transactional(TxType.REQUIRED)
	public String updateTeam(int id, String team) {
		Team old = manager.find(Team.class, id);
		Team update = util.getObjectForJSON(team, Team.class);

		old.setName(update.getName());

		manager.persist(old);
		return "{\"message\": \"Team Name Updated\"}";
	}

	@Transactional(TxType.REQUIRED)
	public String deleteTeam(int id) {

		Team team = manager.find(Team.class, id);

		if (team != null) {
			manager.remove(team);
			return "{\"message\": \"Team deleted\"}";

		} else {

			return "{\"message\": \"Chosen team does not exist\"}";
		}
	}

	public String findATeamUser(int uId) {
		Query query = manager.createNativeQuery(String.format("SELECT TID FROM TEAM WHERE user_uId = " + uId));

		Collection<Team> teams = (Collection<Team>) query.getResultList();

		if (teams.isEmpty()) {
			return "{\"message\": \"No Teams assigned to this user\"}";
		} else {
			return util.getJSONForObject(teams);
		}
	}

	public String getTeamUnits(int tId) {
		
		Query query = manager.createNativeQuery(String.format("SELECT chaRACTER_CID FROM TEAM_UNIT WHERE TEAM_TID =" + tId));

		Collection<Unit> units = (Collection<Unit>) query.getResultList();
		
		return util.getJSONForObject(units);
	}

}
