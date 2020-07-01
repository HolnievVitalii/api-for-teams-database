package com.example.TeamsDbApi.exeption;

public class TeamNotFoundEx extends Exception {
    private Integer team_id;

    public TeamNotFoundEx(Integer team_id) {
        super(String.format("Team is not found with id : '%s'", team_id));
    }
}
