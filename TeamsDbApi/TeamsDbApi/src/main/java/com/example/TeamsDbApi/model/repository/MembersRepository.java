package com.example.TeamsDbApi.model.repository;

import com.example.TeamsDbApi.model.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer> {
}
