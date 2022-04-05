package com.tbz.ch;

public class Citizen extends RequestHandler{
    private String name;
    Notification notification = new Notification();
    Instruction instruction = new Instruction();

    public Instruction execute(){
        return instruction;
    }
}
