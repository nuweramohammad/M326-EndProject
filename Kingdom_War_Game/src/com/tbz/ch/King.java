package com.tbz.ch;

public class King {
    private double bankBalance;
    private RequestHandler militaryChain;
    private RequestHandler populationChain;

    public King() {
        buildChain();
    }

    private void buildChain() {
        militaryChain = new Commander(new Soldier(null));
        populationChain = new Minister(new Citizen(null));
    }

    public void makeRequest(Instruction instruction) {
        if (Command.COLLECT_TAX == instruction.getCommand() || Command.PROTEST == instruction.getCommand()
                || Command.START_SAVING == instruction.getCommand() || Command.START_SPENDING == instruction.getCommand()) {
            populationChain.handleRequest(instruction);
        }else if(Command.SHOOTING_PRACTICE == instruction.getCommand()|| Command.STAMINA_EXERCISES == instruction.getCommand()){
            militaryChain.handleRequest(instruction);
        }
    }

    public Double checkBankBalance() {
        return bankBalance;
    }

    public double getBankBalance() {
        return bankBalance;
    }
}
