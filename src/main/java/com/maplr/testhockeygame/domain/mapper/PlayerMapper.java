package com.maplr.testhockeygame.domain.mapper;

import com.maplr.testhockeygame.domain.model.dto.PlayerDto;
import com.maplr.testhockeygame.domain.model.entity.PlayerEntity;
import com.maplr.testhockeygame.domain.model.util.PositionEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(source = "position", target = "position", qualifiedByName = "toValue")
    PlayerEntity toEntity(PlayerDto playerDto);

    @Mapping(source = "position", target = "position", qualifiedByName = "toEnum")
    PlayerDto toDto(PlayerEntity playerEntity);

    @Named("toValue")
    default String getValueFromPositionEnum(PositionEnum position) {
        return position.getValue();
    }

    @Named("toEnum")
    default PositionEnum getPositionEnumFromValue(String position) {
        return PositionEnum.findByValue(position);
    }

}
