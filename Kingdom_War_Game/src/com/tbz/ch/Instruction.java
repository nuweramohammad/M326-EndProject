package com.tbz.ch;

public class Instruction {
    private Command command;
    private String commandDescription;
    private boolean isSent;

    public Instruction(Command command, String commandDescription) {
        this.command = command;
        this.commandDescription = commandDescription;
    }

    public void markHandled(){
        this.isSent = true;
    }

    public Command getCommand() {
        return command;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public boolean isSent() {
        return isSent;
    }

    @Override
    public String toString() {
        return getCommandDescription();
    }
}
