package com.qa.persistance.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistance.domain.Team;
import com.qa.persistance.domain.Unit;
import com.qa.persistance.domain.User;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TeamDBTest {

	// descirbes the class under test
		@InjectMocks
		private TeamDatabaseRepository repo;

		// Mock gives us what the test requires
		@Mock
		private EntityManager manager;

		private JSONUtil util;

		@Mock
		private Query query;

		
		
		@Before
		public void setup() {
			repo.setManager(manager);
			util = new JSONUtil();
			repo.setUtil(util);
			
		}
		
		@Test
		public void findAllTeams() {
			Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
			List<Team> teams = new ArrayList<>();
			Constants.units.add(Constants.unit1);
			Constants.team1.setCharacters(Constants.units);
			teams.add(Constants.team1);
			
			Mockito.when(query.getResultList()).thenReturn(teams);
			
			Assert.assertEquals(Constants.MOCK_TEAM_DATA_ARRAY1, repo.findAllTeams());
		}
		
		@Test
		public void findAllTeamsEmpty() {
			Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
			List<Team> teams = new ArrayList<>();
			
			Assert.assertEquals(0, teams.size());
			
			Assert.assertEquals("{\"Message\": \"There are no teams to return\"}", repo.findAllTeams());
		}
		
		@Test
		public void findATeamName() {
			Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

			List<Team> teams = new ArrayList<>();
			Constants.units.add(Constants.unit1);
			Constants.team1.setCharacters(Constants.units);
			teams.add(Constants.team1);
			teams.add(Constants.team2);
			
			Mockito.when(query.getResultList()).thenReturn(teams);

			Assert.assertEquals(2, teams.size());
			Assert.assertEquals(Constants.MOCK_TEAM_DATA_ARRAY1, repo.findATeamName("t"));

		}
		
		@Test
		public void findATeamNameMulti() {
			Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

			List<Team> teams = new ArrayList<>();
			Constants.units.add(Constants.unit1);
			Constants.team1.setCharacters(Constants.units);
			Constants.team3.setCharacters(Constants.units);
			teams.add(Constants.team1);
			teams.add(Constants.team2);
			teams.add(Constants.team3);
			
			Mockito.when(query.getResultList()).thenReturn(teams);

			Assert.assertEquals(3, teams.size());
			Assert.assertEquals("[" + Constants.MOCK_TEAM_OBJECT1 +"," + Constants.MOCK_TEAM_OBJECT3 + "]", repo.findATeamName("t"));

		}
	
		@Test
		public void findATeamNameFail() {
			Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

			List<Team> teams = new ArrayList<>();
			
			Mockito.when(query.getResultList()).thenReturn(teams);

			Assert.assertEquals("{\"message\": \"Searched Team does not exist\"}", repo.findATeamName("z"));

		}
		
		
		@Test
		public void createTeam() {
			Assert.assertEquals("{\"message\": \"New Team has been Created\"}", repo.createTeam(Constants.MOCK_TEAM_OBJECT3));
			
		}
		
		@Test
		public void updateTeam() {
			List<Team> teams = new ArrayList<>();
			Constants.units.add(Constants.unit1);
			Constants.team1.setCharacters(Constants.units);
			teams.add(Constants.team1);
			teams.add(Constants.team2);
			
			Mockito.when(manager.find(Team.class, 2)).thenReturn(Constants.team2);
			
			Assert.assertEquals("{\"message\": \"Team Name Updated\"}", repo.updateTeam(2, Constants.MOCK_TEAM_OBJECT4));

		}
		
		
		@Test
		public void deleteTeam() {
			List<Team> teams = new ArrayList<>();
			Constants.units.add(Constants.unit1);
			Constants.team1.setCharacters(Constants.units);
			teams.add(Constants.team1);
			teams.add(Constants.team2);
			
			Mockito.when(manager.find(Team.class, 2)).thenReturn(Constants.team2);
			
			Assert.assertEquals("{\"message\": \"Team deleted\"}", repo.deleteTeam(2));

		}
	
}
