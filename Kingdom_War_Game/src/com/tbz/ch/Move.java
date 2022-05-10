package com.tbz.ch;

/**
 * This enum class is specifically used for the
 * soldier fight against the opponent
 */
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
