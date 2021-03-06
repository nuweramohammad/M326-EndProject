package com.tbz.ch;

public class King {
    private static int bankBalance = 10000;
    private static int checkArmy = 300;
    private RequestHandler militaryChain;
    private RequestHandler populationChain;
    private Soldier soldier;

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

    public static void updateBankBalance(int wins){
        int balance = bankBalance += wins;
        System.out.println("Bank balance: "+ balance);
    }

    public static void updateArmyMan(int wins) {
        int army = checkArmy += wins;
        System.out.println("Army left: "+army);
    }
    public void returnArmyMan(){

    }

    public double getBankBalance() {
        return bankBalance;
    }
}
