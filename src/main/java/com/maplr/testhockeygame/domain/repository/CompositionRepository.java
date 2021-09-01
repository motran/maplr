package com.maplr.testhockeygame.domain.repository;

import com.maplr.testhockeygame.domain.model.entity.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionRepository extends JpaRepository<Composition, Long> {
    Composition findByTeamIdAndPlayerId(long teamId, long playerId);
}
