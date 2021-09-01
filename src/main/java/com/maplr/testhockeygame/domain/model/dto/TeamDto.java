package com.maplr.testhockeygame.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "Team")
@JsonPropertyOrder({"id", "coach", "year", "players"})
public class TeamDto {
    @ApiModelProperty(notes = "Name and lastname of the coach", name = "coach", required = true, example = "Dominique Ducharme")
    private String coach;

    @ApiModelProperty(notes = "id of the team", name = "id", required = true, example = "1")
    private long id;

    private List<PlayerDto> players;

    @ApiModelProperty(notes = "Year of the team", name = "year", required = true, example = "2019")
    private long year;

}
