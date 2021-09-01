package com.maplr.testhockeygame.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.maplr.testhockeygame.domain.model.util.PositionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Player")
@JsonPropertyOrder({"number", "name", "lastname", "position", "isCaptain"})
public class PlayerDto {
    @ApiModelProperty(notes = "Is the player a captain of the team", name = "isCaptain", required = true, example = "false")
    @JsonProperty("isCaptain")
    private boolean isCaptain;

    @ApiModelProperty(notes = "Last name of the player", name = "lastname", required = true, example = "Félix")
    private String lastname;

    @ApiModelProperty(notes = "Name of the player", name = "name", required = true, example = "Marion")
    private String name;

    @ApiModelProperty(notes = "Number of the player", name = "number", required = true, example = "99")
    private long number;

    @ApiModelProperty(notes = "Position of the player", name = "position", allowableValues = "defenseman, forward, goaltender", example = "forward")
    private PositionEnum position;

}
