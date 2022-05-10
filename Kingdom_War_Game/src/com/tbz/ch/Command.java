package com.tbz.ch;

import java.util.ArrayList;

import java.util.List;

/**
 * Enum Class for the different roles to make commands
 */
public enum Command {
    COLLECT_TAX,
    START_SPENDING,
    START_SAVING,
    STAMINA_EXERCISES,
    SHOOTING_PRACTICE,
    PROTEST;

    private static List<Command> commands = new ArrayList<Command>();

    /**
     * Saved the enum values as a ArrayList
     */
    public static void addEnumValues(){
        for (Command c: Command.values()) {
            commands.add(c);
        }
    }

    public static List<Command> getAndAddCommands() {
        addEnumValues();
        return commands;
    }
}
