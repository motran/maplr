package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.domain.model.dto.PlayerDto;
import com.maplr.testhockeygame.domain.model.dto.TeamDto;
import com.maplr.testhockeygame.domain.model.exception.PlayerExistException;
import com.maplr.testhockeygame.domain.model.exception.TeamNotFoundException;

public interface TeamService {
    TeamDto getTeam(long year) throws TeamNotFoundException;
    PlayerDto postPlayer(long year, PlayerDto playerDtoPayload) throws TeamNotFoundException, PlayerExistException;
}
