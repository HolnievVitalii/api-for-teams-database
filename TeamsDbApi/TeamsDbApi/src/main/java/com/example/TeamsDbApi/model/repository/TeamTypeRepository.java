package com.example.TeamsDbApi.model.repository;

import com.example.TeamsDbApi.model.entity.TeamType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamTypeRepository extends JpaRepository<TeamType, Integer> {
}
