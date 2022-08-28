package com.matches.services;

import com.matches.entities.Team;

import java.util.List;
import java.util.Optional;

public interface TeamServiceInterface {

    public Team saveTeam(Team team) throws Exception;

    public Team getTeamByName(String name);

    public Team getTeamByAbbreviation(String abbreviation);

    public List<Team> getAllTeam();

    public Team getTeamById(Long id) throws Exception;
}
