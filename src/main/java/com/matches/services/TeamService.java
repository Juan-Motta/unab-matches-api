package com.matches.services;

import com.matches.entities.Team;
import com.matches.exceptions.ApiRequestException;
import com.matches.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService implements TeamServiceInterface {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team saveTeam(Team team) throws Exception {
        Team team_entity = teamRepository.findByName(team.getName());
        if (team_entity != null){
            System.out.println("El equipo ya existe");
            throw new Exception("El equipo ya existe");
        } else {
            team_entity = teamRepository.save(team);
        }
        return team_entity;
    }

    @Override
    public Team getTeamByName(String name) {
        return teamRepository.findByName(name);
    }

    @Override
    public Team getTeamByAbbreviation(String abbreviation) {
        return teamRepository.findByAbbreviation(abbreviation);
    }

    @Override
    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Long id) throws Exception {
        Team team = teamRepository.findTeamById(id);
        if (team == null) {
            throw new ApiRequestException("Team not found.");
        }
        return teamRepository.findTeamById(id);
    }
}
