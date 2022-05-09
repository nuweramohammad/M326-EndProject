package com.tbz.ch;

import java.util.ArrayList;

import java.util.List;

public enum Command {
    COLLECT_TAX,
    START_SPENDING,
    START_SAVING,
    STAMINA_EXERCISES,
    SHOOTING_PRACTICE,
    PROTEST;

    private static List<Command> commands = new ArrayList<Command>();

    public static void addEnumValues(){
        for (Command c: Command.values()) {
            commands.add(c);
        }
    }

    public static List<Command> getCommands() {
        addEnumValues();
        return commands;
    }




}
