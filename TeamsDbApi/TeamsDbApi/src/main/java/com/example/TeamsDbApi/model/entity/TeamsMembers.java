package com.example.TeamsDbApi.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "teamsmembers")
public class TeamsMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer team_id;

    @Column
    private Integer team_member_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id",referencedColumnName = "id", insertable = false, updatable = false)
    private Teams teams;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_member_id", referencedColumnName = "id",insertable = false,updatable = false)
    private Members members;

    public TeamsMembers(){
        super();
    }

    public TeamsMembers(Integer id, Integer team_id, Integer team_member_id) {
        super();
        this.id = id;
        this.team_id = team_id;
        this.team_member_id = team_member_id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getTeam_member_id() {
        return team_member_id;
    }

    public void setTeam_member_id(Integer team_member_id) {
        this.team_member_id = team_member_id;
    }
}
