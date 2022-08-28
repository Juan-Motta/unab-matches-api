package com.matches.controllers;

import com.matches.entities.Team;
import com.matches.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/api/team")
    public List<Team> getAllTeam() {
        return teamService.getAllTeam();
    }

    @GetMapping("/api/team/{id}")
    public Team getTeamById(@PathVariable("id") Long id) throws Exception {
        return teamService.getTeamById(id);
    }

    @PostMapping("/api/team")
    public Team saveUser(@RequestBody Team team) throws Exception {
        return teamService.saveTeam(team);
    }

}
