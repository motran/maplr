package com.maplr.testhockeygame.domain.model.util;

public class Constant {

    public static final String ERROR_GLOBAL = "Something went wrong. Please contact the administrator.";
    public static final String ERROR_LOG = "Error response sent to the user : {}";
    public static final String ERROR_PARSING = "Error during processing the body";
    public static final String ERROR_PLAYER_ALREADY_EXISTS = "Player already exists";
    public static final String ERROR_PLAYER_NOT_FOUND = "Player not found";
    public static final String ERROR_TEAM_NOT_FOUND = "Team not found";

    public static final String OK = "OK";
    public static final String CREATED = "CREATED";

    //HttpStatus values
    public static final int OK_VALUE = 200;
    public static final int CREATED_VALUE = 201;
    public static final int NOT_MODIFIED_VALUE = 304;
    public static final int NOT_FOUND_VALUE = 404;
    public static final int NOT_ACCEPTABLE_VALUE = 406;

    private Constant() {
    }
}
