package com.matches.controllers;

import com.matches.entities.Team;
import com.matches.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/")
    public List<Team> getAllTeam() {
        return teamService.getAllTeam();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable("id") Long id) throws Exception {
        return teamService.getTeamById(id);
    }

    @PostMapping("/")
    public Team saveUser(@RequestBody Team team) throws Exception {
        return teamService.saveTeam(team);
    }

}
