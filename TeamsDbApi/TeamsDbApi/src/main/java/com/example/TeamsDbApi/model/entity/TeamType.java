package com.example.TeamsDbApi.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "teamtype")
public class TeamType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String team_type;


    public TeamType() {
        super();
    }

    public TeamType(Integer id, String team_type) {
        super();
        this.id = id;
        this.team_type = team_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeam_type() {
        return team_type;
    }

    public void setTeam_type(String team_type) {
        this.team_type = team_type;
    }
}
