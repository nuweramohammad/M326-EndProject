package com.tbz.ch;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Soldier extends RequestHandler {
    private String name = "Soldier";
    private Scanner scanner = new Scanner(System.in);
    private Random_Move random_move = new Random_Move();

    public Soldier(RequestHandler requestHandler) {
        super(requestHandler);
    }

    public Soldier() {
        super();
    }
    public void checkNotification(Instruction instruction){
        if(instruction.getCommand().equals(Command.SHOOTING_PRACTICE)){
            System.out.println(instruction.getCommandDescription());
        }else{
            System.out.println("No notifications");
        }
    }

    @Override
    public void handleRequest(Instruction request) {
        if (Command.SHOOTING_PRACTICE == request.getCommand() || Command.STAMINA_EXERCISES == request.getCommand()) {
            System.out.println(this.name + " Handle request: " + request);
            request.markHandled();
        } else {
            System.out.println("Not a request for the Soldier");
        }
    }

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
                    System.out.println("Your move isn't valid!");
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

    public boolean isPlayerWin(String playerMove, String computerMove) {
        return playerMove.equals(Move.SHOOT.getValue()) && computerMove.equals(Move.DEFEND.getValue())
                || (playerMove.equals(Move.DEFEND.getValue()) && computerMove.equals(Move.SHOOT.getValue()));
    }

}
