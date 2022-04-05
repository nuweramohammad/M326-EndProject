package com.tbz.ch;

public class King {
    private String name;
    private double bankBalance;
    Instruction instruction = new Instruction();
    private RequestHandler requestHandler;

    public Instruction giveHighestCommand(){
        return instruction;
    }

    public Double checkBankBalance(){
        return bankBalance;
    }

    public Instruction takeAdvice(){
        return instruction;
    }
}
