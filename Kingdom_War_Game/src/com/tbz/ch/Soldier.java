package com.tbz.ch;

public class Soldier extends RequestHandler {
    private String name;
    Notification notification = new Notification();
    Instruction instruction = new Instruction();

    public int fight(){
        return 0;
    }

    public Instruction execute(){
        return instruction;
    }
}
