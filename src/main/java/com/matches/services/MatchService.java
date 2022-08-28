package com.matches.services;

import com.matches.entities.Match;
import com.matches.entities.Team;
import com.matches.entities.User;
import com.matches.repositories.MatchRepository;
import com.matches.repositories.TeamRepository;
import com.matches.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService implements MatchServiceInterface {

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Match saveMatch(Match match) {
        System.out.println("Match");
        System.out.println(match);
        User user = userRepository.findUserById(match.getUser().getId());
        Team local_team = teamRepository.findTeamById(match.getAway_team().getId());
        Team away_team = teamRepository.findTeamById(match.getLocal_team().getId());
        match.setUser(user);
        match.setAway_team(away_team);
        match.setLocal_team(local_team);
        return matchRepository.save(match);
    }

    @Override
    public List<Match> getMatchList() {
        return null;
    }

    @Override
    public Match getMatchById(Long id) {
        return null;
    }

    @Override
    public void deleteMatchById(Long id) {

    }

    @Override
    public Match updateMatchById(Match match, Long id) {
        Match match_entity = matchRepository.findById(id).get();
        // Validations
        if (match.getAway_team_goals() != null) {
            match_entity.setAway_team_goals(match.getAway_team_goals());
        }
        if (match.getLocal_team_goals() != null) {
            match_entity.setLocal_team_goals(match.getLocal_team_goals());
        }
        return this.saveMatch(match_entity);
    }
}
