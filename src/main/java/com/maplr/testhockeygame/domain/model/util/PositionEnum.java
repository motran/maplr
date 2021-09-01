package com.maplr.testhockeygame.domain.model.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PositionEnum {
    @JsonProperty("defenseman")
    DEFENSEMAN("defenseman"),
    @JsonProperty("forward")
    FORWARD("forward"),
    @JsonProperty("goaltender")
    GOALTENDER("goaltender");

    private String value;

    PositionEnum(String value) {
        this.value = value;
    }

    public static PositionEnum findByValue(String value) {
        for (PositionEnum p : PositionEnum.values()) {
            if (p.getValue().equalsIgnoreCase(value)) {
                return p;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return this.getValue();
    }
}
