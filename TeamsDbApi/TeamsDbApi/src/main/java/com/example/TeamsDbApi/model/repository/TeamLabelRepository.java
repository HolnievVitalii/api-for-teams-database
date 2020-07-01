package com.example.TeamsDbApi.model.repository;

import com.example.TeamsDbApi.model.entity.TeamLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamLabelRepository extends JpaRepository<TeamLabel, Integer> {
}
