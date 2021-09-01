package com.maplr.testhockeygame.domain.mapper;

import com.maplr.testhockeygame.domain.model.dto.TeamDto;
import com.maplr.testhockeygame.domain.model.entity.TeamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PlayerMapper.class})
public interface TeamMapper {

    TeamDto toDto(TeamEntity teamEntity);

}
