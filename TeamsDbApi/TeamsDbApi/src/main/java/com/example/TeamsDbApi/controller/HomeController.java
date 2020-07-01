package com.example.TeamsDbApi.controller;

import com.example.TeamsDbApi.exeption.TeamNotFoundEx;
import com.example.TeamsDbApi.model.entity.Teams;
import com.example.TeamsDbApi.model.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    TeamsRepository teamsRepository;

    @RequestMapping("/description")
    public String home() {
        return "test task for Java Developer position on Sberbank DevOps";
    }

    // Get all Records
    @GetMapping("/teams")
    public List getAllTeams() {
        return teamsRepository.findAll();
    }

    // Create Record
    @PostMapping("/create_team")
    @ResponseStatus(HttpStatus.CREATED)
    public Teams createTeam(@RequestBody Teams team) {
        return teamsRepository.save(team);
    }
    // Get Record by id
    @GetMapping("/teams/{id}")
    public Teams getTeamById(@PathVariable(value = "id") Integer teamId) throws TeamNotFoundEx {
        return teamsRepository.findById(teamId).orElseThrow(() -> new TeamNotFoundEx(teamId));
    }

    // Update Record by id
    @PutMapping("/update_team/{id}")
    public Teams updateTeam(@PathVariable(value = "id") Integer teamId, @RequestBody Teams teamDetails) throws TeamNotFoundEx {
        Teams team = teamsRepository.findById(teamId).orElseThrow(()->new TeamNotFoundEx(teamId));
        team.setTeam_name(teamDetails.getTeam_name());
        team.setTeam_type_id(teamDetails.getTeam_type_id());
        team.setTeam_label_id(teamDetails.getTeam_label_id());

        Teams updatedTeam = teamsRepository.save(team);
        return updatedTeam;
    }

    // Delete record by id
    @DeleteMapping("/delete_team/{id}")
    public ResponseEntity deleteTeam(@PathVariable(value = "id") Integer teamId) throws TeamNotFoundEx {
        Teams team = teamsRepository.findById(teamId).orElseThrow(()-> new TeamNotFoundEx(teamId));
        teamsRepository.delete(team);
        return ResponseEntity.ok().build();
    }
}
