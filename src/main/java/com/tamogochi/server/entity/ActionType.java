package com.tamogochi.server.entity;

public enum  ActionType {
    PLAY("PLAY"),
    FEED("FEED"),
    BATH("BATH"),
    SLEEP("SLEEP"),
    TREAT("TREAT");

    private String name;

    ActionType(String name) {
        this.name = name;
    }
}
