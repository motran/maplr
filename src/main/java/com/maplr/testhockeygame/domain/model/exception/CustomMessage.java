package com.maplr.testhockeygame.domain.model.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomMessage {
    private String message;
    private String detail;

    public CustomMessage(String message) {
        this.message = message;
    }

    public CustomMessage(String message, String detail) {
        this.message = message;
        this.detail = detail;
    }
}
