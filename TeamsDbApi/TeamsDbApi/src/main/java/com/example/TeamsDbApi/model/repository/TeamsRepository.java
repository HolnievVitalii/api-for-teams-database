package com.example.TeamsDbApi.model.repository;

import com.example.TeamsDbApi.model.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {
}
