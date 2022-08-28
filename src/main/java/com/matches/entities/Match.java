package com.matches.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "local_team_id", referencedColumnName = "id")
    private Team local_team;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "away_team_id", referencedColumnName = "id")
    private Team away_team;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date date;
    private Long away_team_goals;
    private Long local_team_goals;

    public Match() {
    }

    public Match(Long id, User user, Team local_team, Team away_team, Date date, Long away_team_goals, Long local_team_goals) {
        this.id = id;
        this.user = user;
        this.local_team = local_team;
        this.away_team = away_team;
        this.date = date;
        this.away_team_goals = away_team_goals;
        this.local_team_goals = local_team_goals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getLocal_team() {
        return local_team;
    }

    public void setLocal_team(Team local_team) {
        this.local_team = local_team;
    }

    public Team getAway_team() {
        return away_team;
    }

    public void setAway_team(Team away_team) {
        this.away_team = away_team;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAway_team_goals() {
        return away_team_goals;
    }

    public void setAway_team_goals(Long away_team_goals) {
        this.away_team_goals = away_team_goals;
    }

    public Long getLocal_team_goals() {
        return local_team_goals;
    }

    public void setLocal_team_goals(Long local_team_goals) {
        this.local_team_goals = local_team_goals;
    }
}
