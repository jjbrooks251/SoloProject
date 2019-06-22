package com.qa.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.TeamServiceImpl;
import com.qa.persistance.repository.Constants;

@RunWith(MockitoJUnitRunner.class)
public class TeamRestTest {

	@InjectMocks
	private TeamControl control ;

	@Mock
	private TeamServiceImpl service;

	@Before
	public void setup() {

	}
	
	@Test
	public void createTeam() {
		Mockito.when(service.createTeam(Constants.MOCK_TEAM_OBJECT3)).thenReturn("{\"message\": \"New Team has been Created\"}");
		Assert.assertEquals("{\"message\": \"New Team has been Created\"}", control.createTeam(Constants.MOCK_TEAM_OBJECT3));
	}
	
	@Test
	public void findAllTeams() {
		Mockito.when(service.findAllTeams()).thenReturn(Constants.MOCK_TEAM_OBJECT3);
		Assert.assertEquals(Constants.MOCK_TEAM_OBJECT3, control.findAllTeams());
	}
	
	@Test
	public void findATeamName() {
		Mockito.when(service.findATeamName("team")).thenReturn("{\"message\": \"\"}");
		Assert.assertEquals("{\"message\": \"\"}", control.findATeamName("team"));
	}
	
	@Test
	public void updateTeam() {
		Mockito.when(service.updateTeam(1, Constants.MOCK_TEAM_OBJECT3)).thenReturn("{\"message\": \"Team Name Updated\"}");
		Assert.assertEquals("{\"message\": \"Team Name Updated\"}", control.updateTeam(1, Constants.MOCK_TEAM_OBJECT3));
	}
	
	@Test
	public void deleteTeam() {
		Mockito.when(service.deleteTeam(1)).thenReturn("{\"message\": \"Team deleted\"}");
		Assert.assertEquals("{\"message\": \"Team deleted\"}", control.deleteTeam(1));
	}
	
}
