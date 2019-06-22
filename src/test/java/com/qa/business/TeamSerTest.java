package com.qa.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistance.repository.Constants;
import com.qa.persistance.repository.TeamDatabaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class TeamSerTest {

	@InjectMocks
	private TeamServiceImpl service;

	@Mock
	private TeamDatabaseRepository repo;

	@Before
	public void setup() {

	}
	
	@Test
	public void createTeam() {
		Mockito.when(repo.createTeam(Constants.MOCK_TEAM_OBJECT3)).thenReturn("{\"message\": \"New Team has been Created\"}");
		Assert.assertEquals("{\"message\": \"New Team has been Created\"}", service.createTeam(Constants.MOCK_TEAM_OBJECT3));
	}
	
	@Test
	public void findAllTeams() {
		Mockito.when(repo.findAllTeams()).thenReturn(Constants.MOCK_TEAM_OBJECT3);
		Assert.assertEquals(Constants.MOCK_TEAM_OBJECT3, service.findAllTeams());
	}
	
	@Test
	public void findATeamName() {
		Mockito.when(repo.findATeamName("team")).thenReturn("{\"message\": \"\"}");
		Assert.assertEquals("{\"message\": \"\"}", service.findATeamName("team"));
	}
	
	@Test
	public void updateTeam() {
		Mockito.when(repo.updateTeam(1, Constants.MOCK_TEAM_OBJECT3)).thenReturn("{\"message\": \"Team Name Updated\"}");
		Assert.assertEquals("{\"message\": \"Team Name Updated\"}", service.updateTeam(1, Constants.MOCK_TEAM_OBJECT3));
	}
	
	@Test
	public void deleteTeam() {
		Mockito.when(repo.deleteTeam(1)).thenReturn("{\"message\": \"Team deleted\"}");
		Assert.assertEquals("{\"message\": \"Team deleted\"}", service.deleteTeam(1));
	}
	
}
