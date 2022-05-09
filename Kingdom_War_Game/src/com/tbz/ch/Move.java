package com.tbz.ch;

public enum Move {
    SHOOT("shoot"),
    DEFEND("defend");

    private String value;

    Move(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
