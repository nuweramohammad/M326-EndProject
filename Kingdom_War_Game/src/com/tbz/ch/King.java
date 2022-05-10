package com.tbz.ch;

public class King {
    private static int bankBalance = 10000;
    private static int checkArmy = 300;
    private RequestHandler militaryChain;
    private RequestHandler populationChain;

    public King() {
        buildChain();
    }

    /**
     * Builds the chain, the distinction between commander
     * and minister takes place here because they are
     * on the same level in the program right below are
     * these two
     */
    private void buildChain() {
        militaryChain = new Commander(new Soldier(null));
        populationChain = new Minister(new Citizen(null));
    }

    /**
     * This is the core of the program where all the chains start
     * to build. The king is in our program the head as soon as
     * he makes an instruction it checks for the command and
     * according to it, it's passed on
     * @param instruction
     */
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

}
