package com.example.TeamsDbApi.model.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "teamsmembers")
public class TeamsMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer team_id;

    @Column
    private Integer member_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id",referencedColumnName = "id", insertable = false, updatable = false)
    private Teams teams;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_member_id", referencedColumnName = "id",insertable = false,updatable = false)
    private Members members;

    public TeamsMembers(){
        super();
    }

    public TeamsMembers(Integer id, Integer team_id, Integer member_id) {
        super();
        this.id = id;
        this.team_id = team_id;
        this.member_id = member_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }
}
