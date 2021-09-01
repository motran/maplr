package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.domain.model.dto.PlayerDto;
import com.maplr.testhockeygame.domain.model.exception.PlayerNotFoundException;

public interface PlayerService {
    PlayerDto modifyCaptainPlayer(long id) throws PlayerNotFoundException;
}
