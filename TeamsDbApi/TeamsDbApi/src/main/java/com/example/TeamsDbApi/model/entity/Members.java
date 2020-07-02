package com.example.TeamsDbApi.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String member_full_name;

    @Column
    private String member_position;

    @Column
    private String member_age;

    public Members() {
        super();
    }

    public Members(Integer id, String member_full_name, String member_position, String member_age) {
        super();
        this.id = id;
        this.member_full_name = member_full_name;
        this.member_position = member_position;
        this.member_age = member_age;
    }

    public Integer getId() {
        return id;
    }

    public String getMember_full_name() {
        return member_full_name;
    }

    public void setMember_full_name(String member_full_name) {
        this.member_full_name = member_full_name;
    }

    public String getMember_position() {
        return member_position;
    }

    public void setMember_position(String member_position) {
        this.member_position = member_position;
    }

    public String getMember_age() {
        return member_age;
    }

    public void setMember_age(String member_age) {
        this.member_age = member_age;
    }
}
