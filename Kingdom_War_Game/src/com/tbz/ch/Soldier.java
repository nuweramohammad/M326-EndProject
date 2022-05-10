package com.tbz.ch;

import java.util.Arrays;
import java.util.Scanner;

public class Soldier extends RequestHandler {
    private Scanner scanner = new Scanner(System.in);
    private Random_Move random_move = new Random_Move();

    public Soldier(RequestHandler requestHandler) {
        super(requestHandler);
    }

    public Soldier() {
        super();
    }

    /**
     * If the king makes a command and if one of the following
     * Commands is mentioned the soldier can check for notifications
     * in his menu.
     * @param instruction
     */
    @Override
    public void checkNotification(Instruction instruction){
        if(instruction.getCommand().equals(Command.SHOOTING_PRACTICE)|| instruction.getCommand().equals(Command.STAMINA_EXERCISES)){
            System.out.println(instruction.getCommandDescription());
        }else{
            System.out.println("No notifications");
        }
    }

    /**
     * This method is inherited from the Request Handler and checks
     * if it's something for the soldier the description of the command
     * is printed else it can't be passed because it reached the end of chain
     * @param request
     */
    @Override
    public void handleRequest(Instruction request) {
        if (Command.SHOOTING_PRACTICE == request.getCommand() || Command.STAMINA_EXERCISES == request.getCommand()) {
            System.out.println("Passing Command to Soldier; " + request);
            request.markHandled();
        } else {
            System.out.println("Not a request for the Soldier");
        }
    }

    /**
     * This method gets called when the user is a soldier
     * and wants to fight. It gives the user options on
     * how to play this game. The move from the opponent is
     * generated randomly, this method is used from the Random_Move
     * class. If the user wins, he gains money for his kingdom
     * but if he looses the kingdom looses a 1000 from the caisse.
     * The soldier and balance variable save the amount of soldiers or
     * the bank balance of the kingdom.
     * @param performOutput
     */
    public void fight(boolean performOutput) {
        int wins = 0;
        int losses = 0;
        int balance = 0;
        int soldier= 0;

        while(performOutput) {

            System.out.println("Welcome to the war zone! Please enter \"shoot\", \"defend\" or \"quit\" to exit.");

            do {
                System.out.println("-------------------------");
                System.out.print("Enter your move: ");
                String playerMove = scanner.nextLine();

                if (playerMove.equals("quit")) {
                    System.out.println("You won " + wins + " times and lost " + losses + " times.");
                    System.out.println("Thanks for helping your king!");
                    performOutput = false;
                    break;
                }

                if (Arrays.stream(Move.values()).noneMatch(x -> x.getValue().equals(playerMove))) {
                    System.out.println(IOHandler.RED + "Your move isn't valid!" + IOHandler.RESET);
                    continue;
                }

                String computerMove = random_move.getComputerMove();

                if (playerMove.equals(computerMove)) {
                    System.out.println("It's a tie!");
                } else if (isPlayerWin(playerMove, computerMove)) {
                    System.out.println("You won!");
                    wins++;
                    soldier++;
                    balance += 1000;
                } else {
                    System.out.println("You lost!");
                    losses++;
                    soldier--;
                    balance -= 1000;
                }

            } while ((balance < 0 || balance < 3000));
            performOutput = false;
        }
        System.out.println("\nThis is the end result of the war of kingdoms..");
        King.updateArmyMan(soldier);
        King.updateBankBalance(balance);
    }

    /**
     * Defines the rules on how the user wins
     * @param playerMove what the user types in
     * @param computerMove generated randomly
     * @return either if the user won: true else false
     */
    public boolean isPlayerWin(String playerMove, String computerMove) {
        return playerMove.equals(Move.SHOOT.getValue()) && computerMove.equals(Move.DEFEND.getValue())
                || (playerMove.equals(Move.DEFEND.getValue()) && computerMove.equals(Move.SHOOT.getValue()));
    }

}
