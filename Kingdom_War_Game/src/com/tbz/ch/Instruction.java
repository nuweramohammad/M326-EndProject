package com.tbz.ch;

public class Instruction {
    private Command command;
    private String commmandDescription;
    private boolean isSent;

    public Instruction(Command command, String commmandDescription) {
        this.command = command;
        this.commmandDescription = commmandDescription;
    }

    public void markHandled(){
        this.isSent = true;
    }

    public Command getCommand() {
        return command;
    }

    public String getCommmandDescription() {
        return commmandDescription;
    }

    public boolean isSent() {
        return isSent;
    }

    @Override
    public String toString() {
        return getCommmandDescription();
    }
}
