package com.example.TeamsDbApi.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String team_name;

    @Column
    private int team_type_id;

    @Column
    private int team_label_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TeamType teamType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_label_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TeamLabel teamLabel;

    public Teams(){
        super();
    }

    public Teams(Integer id, String team_name, int team_type_id, int team_label_id) {
        super();
        this.id = id;
        this.team_name = team_name;
        this.team_type_id = team_type_id;
        this.team_label_id = team_label_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getTeam_type_id() {
        return team_type_id;
    }

    public void setTeam_type_id(int team_type_id) {
        this.team_type_id = team_type_id;
    }

    public int getTeam_label_id() {
        return team_label_id;
    }

    public void setTeam_label_id(int team_label_id) {
        this.team_label_id = team_label_id;
    }
}
