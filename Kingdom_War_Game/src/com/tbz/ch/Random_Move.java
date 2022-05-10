package com.tbz.ch;

import java.util.Random;

public class Random_Move {

    private Random random = new Random();

    /**
     * This method generates random number 0 or 1
     * and prints opponents move it can either be
     * defend or shoot
     * @return
     */
    public String getComputerMove() {
        int randomNumber = random.nextInt(2);
        String computerMove = Move.values()[randomNumber].getValue();
        System.out.println("Computer move: " + computerMove);
        return computerMove;
    }
}
