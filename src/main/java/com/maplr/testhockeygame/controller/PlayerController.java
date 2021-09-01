package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.domain.model.dto.PlayerDto;
import com.maplr.testhockeygame.domain.model.exception.PlayerNotFoundException;
import com.maplr.testhockeygame.domain.model.util.Constant;
import com.maplr.testhockeygame.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${basePath}/player")
@Api(tags = "Player")
@SuppressWarnings("unused")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @ApiOperation(value = "Make player captain")
    @ApiResponses(value = {
            @ApiResponse(code = Constant.OK_VALUE, message = Constant.OK),
            @ApiResponse(code = Constant.NOT_FOUND_VALUE, message = Constant.ERROR_PLAYER_NOT_FOUND)})
    @PutMapping(path = "/captain/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<PlayerDto> modifyCaptainPlayer(
            @ApiParam(name = "id", type = "long", value = "id of the player", example = "1", defaultValue = "1", required = true)
            @PathVariable(value = "id") long id) throws PlayerNotFoundException {
        PlayerDto playerDto = playerService.modifyCaptainPlayer(id);
        return new ResponseEntity<>(playerDto, HttpStatus.OK);
    }

}
