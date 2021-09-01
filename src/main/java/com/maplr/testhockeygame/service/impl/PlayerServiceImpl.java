package com.maplr.testhockeygame.service.impl;

import com.maplr.testhockeygame.domain.mapper.PlayerMapper;
import com.maplr.testhockeygame.domain.model.dto.PlayerDto;
import com.maplr.testhockeygame.domain.model.entity.PlayerEntity;
import com.maplr.testhockeygame.domain.model.exception.PlayerNotFoundException;
import com.maplr.testhockeygame.domain.repository.PlayerRepository;
import com.maplr.testhockeygame.domain.repository.TeamRepository;
import com.maplr.testhockeygame.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public PlayerDto modifyCaptainPlayer(long id) throws PlayerNotFoundException {
        PlayerEntity playerEntityFound = playerRepository.findById(id);
        if (playerEntityFound != null) {
            playerEntityFound.setCaptain(true);
            PlayerEntity playerEntitySaved = playerRepository.save(playerEntityFound);
            return playerMapper.toDto(playerEntitySaved);
        } else {
            throw new PlayerNotFoundException();
        }
    }
}
