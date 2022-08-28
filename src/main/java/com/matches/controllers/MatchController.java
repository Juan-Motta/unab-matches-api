package com.matches.controllers;

import com.matches.entities.Match;
import com.matches.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/")
    public Match saveMatch(@RequestBody Match match) throws Exception{
        return matchService.saveMatch(match);
    }

    @PutMapping("/{id}")
    public Match updateMatch(@RequestBody Match match, @PathVariable("id") Long id) {
        return matchService.updateMatchById(match, id);
    }


}
