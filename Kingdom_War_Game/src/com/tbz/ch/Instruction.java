package com.tbz.ch;

/**
 * Instruction consists of a command
 * and a description
 */
public class Instruction {
    private Command command;
    private String commandDescription;
    private boolean isSent;

    public Instruction(Command command, String commandDescription) {
        this.command = command;
        this.commandDescription = commandDescription;
    }

    /**
     * As soon as the command is passed
     * it's marked as sent so that the chain
     * can be ended
     */
    public void markHandled(){
        this.isSent = true;
    }

    public Command getCommand() {
        return command;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    @Override
    public String toString() {
        return getCommandDescription();
    }
}
