package com.example.TeamsDbApi.exeption;

public class MemberNotFoundEx extends Exception {
    private Integer member_id;

    public MemberNotFoundEx(Integer member_id) {
        super(String.format("Member is not found with id : '%s'", member_id));
    }
}
