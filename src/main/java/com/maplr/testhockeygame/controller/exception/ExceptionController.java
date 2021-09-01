package com.maplr.testhockeygame.controller.exception;

import com.maplr.testhockeygame.domain.model.exception.CustomMessage;
import com.maplr.testhockeygame.domain.model.exception.PlayerExistException;
import com.maplr.testhockeygame.domain.model.exception.PlayerNotFoundException;
import com.maplr.testhockeygame.domain.model.exception.TeamNotFoundException;
import com.maplr.testhockeygame.domain.model.util.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@SuppressWarnings("unused")
public class ExceptionController {
    private static final Logger LOGGER = LogManager.getLogger(ExceptionController.class);

    @ExceptionHandler(value = TeamNotFoundException.class)
    public ResponseEntity<CustomMessage> teamNotFoundException() {
        ResponseEntity<CustomMessage> response = new ResponseEntity<>(new CustomMessage(Constant.ERROR_TEAM_NOT_FOUND), HttpStatus.NOT_FOUND);
        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn(Constant.ERROR_LOG, response);
        }
        return response;
    }

    @ExceptionHandler(value = PlayerNotFoundException.class)
    public ResponseEntity<CustomMessage> playerNotFoundException() {
        ResponseEntity<CustomMessage> response = new ResponseEntity<>(new CustomMessage(Constant.ERROR_PLAYER_NOT_FOUND), HttpStatus.NOT_FOUND);
        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn(Constant.ERROR_LOG, response);
        }
        return response;
    }

    @ExceptionHandler(value = PlayerExistException.class)
    public ResponseEntity<CustomMessage> playerExistException() {
        ResponseEntity<CustomMessage> response = new ResponseEntity<>(new CustomMessage(Constant.ERROR_PLAYER_ALREADY_EXISTS), HttpStatus.NOT_MODIFIED);
        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn(Constant.ERROR_LOG, response);
        }
        return response;
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<CustomMessage> parseException(HttpMessageNotReadableException exception) {
        ResponseEntity<CustomMessage> response = new ResponseEntity<>(new CustomMessage(Constant.ERROR_PARSING, exception.getMessage()), HttpStatus.NOT_ACCEPTABLE);
        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn(Constant.ERROR_LOG, response);
        }
        return response;
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<CustomMessage> runTimeException(RuntimeException runTimeException) {
        ResponseEntity<CustomMessage> response = new ResponseEntity<>(new CustomMessage(Constant.ERROR_GLOBAL, runTimeException.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn(Constant.ERROR_LOG, response);
        }
        return response;
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CustomMessage> exception(Exception exception) {
        ResponseEntity<CustomMessage> response = new ResponseEntity<>(new CustomMessage(Constant.ERROR_GLOBAL, exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn(Constant.ERROR_LOG, response);
        }
        return response;
    }

}
