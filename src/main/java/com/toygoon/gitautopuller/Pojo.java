package com.toygoon.gitautopuller;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;

/**
 * Saves some information from the hooked data.
 */
@Getter
public class Pojo {
    private final String username;
    private final String repository;
    private final String type;
    private final String action;

    /**
     * To parse the created JSON file for the POST mapped
     * @param username
     * @param repository
     * @param type
     * @param action
     */
    @JsonCreator
    public Pojo(String username, String repository, String type, String action) {
        this.username = username;
        this.repository = repository;
        this.type = type;
        this.action = action;
    }
}
