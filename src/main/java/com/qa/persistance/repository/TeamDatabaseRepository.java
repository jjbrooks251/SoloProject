package com.qa.persistance.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistance.domain.Team;
import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class TeamDatabaseRepository implements TeamRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	@Override
	public String createTeam(String team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findAllTeams() {
		Query query = manager.createQuery("SELECT a FROM Team a");

		Collection<Team> teams = (Collection<Team>) query.getResultList();

		return util.getJSONForObject(teams);
	}

	@Override
	public String findATeamId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findATeamName(String team) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String updateTeam(int id, String team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTeam(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
