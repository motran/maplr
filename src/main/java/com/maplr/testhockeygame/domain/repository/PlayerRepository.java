package com.maplr.testhockeygame.domain.repository;

import com.maplr.testhockeygame.domain.model.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    PlayerEntity findById(long id);
    PlayerEntity findByNumber(long number);
}
