package com.matches.services;

import com.matches.entities.Match;

import java.util.List;

public interface MatchServiceInterface {

    public Match saveMatch(Match match);

    public List<Match> getMatchList();

    public Match getMatchById(Long id);

    public void deleteMatchById(Long id);

    public Match updateMatchById(Match ride, Long id);
}
