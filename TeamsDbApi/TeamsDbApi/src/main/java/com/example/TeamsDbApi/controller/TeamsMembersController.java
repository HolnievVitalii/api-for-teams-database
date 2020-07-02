package com.example.TeamsDbApi.controller;

import com.example.TeamsDbApi.exeption.TeamMemberNotFoundEx;
import com.example.TeamsDbApi.model.entity.TeamsMembers;
import com.example.TeamsDbApi.model.repository.TeamsMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamsMembersController {

    @Autowired
    TeamsMembersRepository teamsMembersRepository;

    // Get all relation team/member
    @GetMapping("/team_members")
    public List getAllTeamMembers(){
        return teamsMembersRepository.findAll();
    }

    // Create relation between team and member (add member to team)
    @PostMapping("/add_member_to_team")
    public TeamsMembers addMemberToTeam(@RequestBody TeamsMembers teamsMember) {
        return teamsMembersRepository.save(teamsMember);
    }

    // Get team member by team/member relation id
    @GetMapping("/team_members/{id}")
    public TeamsMembers getTeamMemberById(@PathVariable(value = "id") Integer teamMemberId) throws TeamMemberNotFoundEx {
        return teamsMembersRepository.findById(teamMemberId).orElseThrow(()-> new TeamMemberNotFoundEx(teamMemberId));
    }

    // Changing the team for member
    @PutMapping("/change_team/{id}")
    public TeamsMembers changeTeamForMember(@PathVariable(value = "id") Integer teamMemberId, @RequestBody TeamsMembers teamsMembersDetails) throws TeamMemberNotFoundEx {
        TeamsMembers teamsMember = teamsMembersRepository.findById(teamMemberId).orElseThrow(()-> new TeamMemberNotFoundEx(teamMemberId));

        teamsMember.setTeam_id(teamsMembersDetails.getTeam_id());
        teamsMember.setTeam_member_id(teamsMembersDetails.getTeam_member_id());

        TeamsMembers updatedTeam = teamsMembersRepository.save(teamsMember);
        return updatedTeam;
    }

    // Delete member from team
    @DeleteMapping("/delete_member_from_team/{id}")
    public ResponseEntity deleteMemberFromTeam(@PathVariable(value = "id") Integer teamMembersId) throws TeamMemberNotFoundEx {
        TeamsMembers teamsMember = teamsMembersRepository.findById(teamMembersId).orElseThrow(()->new TeamMemberNotFoundEx(teamMembersId));

        teamsMembersRepository.delete(teamsMember);
        return ResponseEntity.ok().build();
    }

}
