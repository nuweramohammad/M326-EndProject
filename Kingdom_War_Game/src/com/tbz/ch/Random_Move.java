package com.tbz.ch;

import java.util.Random;

public class Random_Move {

    private Random random = new Random();

    public String getComputerMove() {
        int randomNumber = random.nextInt(2);
        String computerMove = Move.values()[randomNumber].getValue();
        System.out.println("Computer move: " + computerMove);
        return computerMove;
    }
}
