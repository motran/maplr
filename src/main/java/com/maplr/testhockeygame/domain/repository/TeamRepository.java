package com.maplr.testhockeygame.domain.repository;

import com.maplr.testhockeygame.domain.model.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    TeamEntity findByYear(long year);
    TeamEntity getTeamByYear(long year);
}
