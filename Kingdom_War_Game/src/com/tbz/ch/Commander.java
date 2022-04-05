package com.tbz.ch;

public class Commander extends RequestHandler{
    private String name;
    Notification notification = new Notification();
    Instruction instruction = new Instruction();

    public void handleRequest(){}
    public Instruction giveInstruction(){
        return instruction;
    }
}
