package com.example.TeamsDbApi.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "teamlabel")
public class TeamLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String team_label;

    public TeamLabel() {
        super();
    }

    public TeamLabel(Integer id, String team_label) {
        super();
        this.id = id;
        this.team_label = team_label;
    }


}
