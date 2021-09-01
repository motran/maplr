package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.domain.model.dto.PlayerDto;
import com.maplr.testhockeygame.domain.model.dto.TeamDto;
import com.maplr.testhockeygame.domain.model.exception.PlayerExistException;
import com.maplr.testhockeygame.domain.model.exception.TeamNotFoundException;
import com.maplr.testhockeygame.domain.model.util.Constant;
import com.maplr.testhockeygame.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${basePath}/team")
@Api(tags = "Team")
@SuppressWarnings("unused")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @ApiOperation(value = "Get team by year")
    @ApiResponses(value = {
            @ApiResponse(code = Constant.OK_VALUE, message = Constant.OK),
            @ApiResponse(code = Constant.NOT_FOUND_VALUE, message = Constant.ERROR_TEAM_NOT_FOUND)})
    @GetMapping(path = "/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<TeamDto> getTeamByYear(
            @ApiParam(name = "year", type = "long", value = "year of the team", example = "2019", defaultValue = "2019", required = true)
            @PathVariable(value = "year") long year) throws TeamNotFoundException {
        TeamDto teamDto = teamService.getTeam(year);
        return new ResponseEntity<>(teamDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Add player in team year")
    @ApiResponses(value = {
            @ApiResponse(code = Constant.CREATED_VALUE, message = Constant.CREATED),
            @ApiResponse(code = Constant.NOT_MODIFIED_VALUE, message = Constant.ERROR_PLAYER_ALREADY_EXISTS),
            @ApiResponse(code = Constant.NOT_FOUND_VALUE, message = Constant.ERROR_TEAM_NOT_FOUND),
            @ApiResponse(code = Constant.NOT_ACCEPTABLE_VALUE, message = Constant.ERROR_PARSING)})
    @PostMapping(path = "/{year}", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<PlayerDto> createPlayer(
            @ApiParam(name = "year", type = "long", value = "year of the team", example = "2019", defaultValue = "2019", required = true)
            @PathVariable(value = "year") long year, @RequestBody PlayerDto player)
            throws TeamNotFoundException, PlayerExistException {
        PlayerDto playerDto = teamService.postPlayer(year, player);
        return new ResponseEntity<>(playerDto, HttpStatus.CREATED);
    }
}
