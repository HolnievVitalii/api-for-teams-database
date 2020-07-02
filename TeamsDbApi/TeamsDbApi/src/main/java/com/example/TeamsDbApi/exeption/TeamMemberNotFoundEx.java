package com.example.TeamsDbApi.exeption;

public class TeamMemberNotFoundEx extends Exception {
    private Integer team_members_id;

    public TeamMemberNotFoundEx(Integer team_members_id) {
        super(String.format("Team member is not found with id : '%s'", team_members_id));
    }
}
