package com.example.TeamsDbApi.model.repository;

import com.example.TeamsDbApi.model.entity.TeamsMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsMembersRepository extends JpaRepository<TeamsMembers, Integer> {
}
