package com.maplr.testhockeygame.service.impl;

import com.maplr.testhockeygame.domain.mapper.PlayerMapper;
import com.maplr.testhockeygame.domain.mapper.TeamMapper;
import com.maplr.testhockeygame.domain.model.dto.PlayerDto;
import com.maplr.testhockeygame.domain.model.dto.TeamDto;
import com.maplr.testhockeygame.domain.model.entity.Composition;
import com.maplr.testhockeygame.domain.model.entity.PlayerEntity;
import com.maplr.testhockeygame.domain.model.entity.TeamEntity;
import com.maplr.testhockeygame.domain.model.exception.PlayerExistException;
import com.maplr.testhockeygame.domain.model.exception.TeamNotFoundException;
import com.maplr.testhockeygame.domain.repository.CompositionRepository;
import com.maplr.testhockeygame.domain.repository.PlayerRepository;
import com.maplr.testhockeygame.domain.repository.TeamRepository;
import com.maplr.testhockeygame.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private CompositionRepository compositionRepository;
    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public TeamDto getTeam(long year) throws TeamNotFoundException {
        TeamEntity teamEntityFound = teamRepository.findByYear(year);
        if (teamEntityFound != null) {
            return teamMapper.toDto(teamEntityFound);
        } else {
            throw new TeamNotFoundException();
        }
    }

    @Override
    public PlayerDto postPlayer(long year, PlayerDto playerDtoBody) throws TeamNotFoundException, PlayerExistException {
        PlayerEntity playerEntityFound = playerRepository.findByNumber(playerDtoBody.getNumber());
        TeamEntity teamEntity = teamRepository.getTeamByYear(year);
        if (teamEntity == null) {
            throw new TeamNotFoundException();
        }
        PlayerEntity playerEntity;
        if (playerEntityFound == null) {
            //create the new player
            PlayerEntity playerEntityMapper = playerMapper.toEntity(playerDtoBody);
            playerEntityMapper.getTeam().add(teamEntity);
            playerEntity = playerRepository.save(playerEntityMapper);
        } else if (compositionRepository.findByTeamIdAndPlayerId(teamEntity.getId(), playerEntityFound.getId()) == null) {
            Composition composition = new Composition(teamEntity.getId(), playerEntityFound.getId());
            compositionRepository.save(composition);
            playerEntity = playerEntityFound;
        } else {
            throw new PlayerExistException();
        }
        return playerMapper.toDto(playerEntity);
    }

}
