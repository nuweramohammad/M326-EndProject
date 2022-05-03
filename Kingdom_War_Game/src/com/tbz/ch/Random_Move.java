package com.tbz.ch;

import java.util.Random;

public class Random_Move {
    private Random random = new Random();

    public Move chooseRandomMove() {
        int randMove = random.nextInt(3);
        Move opponentMove;
        if (randMove == 0) {
            opponentMove = Move.BEND;
        } else if (randMove == 1) {
            opponentMove = Move.SHOOT;
        } else {
            opponentMove = Move.DEFEND;
        }
        System.out.println("Opponent chose " + opponentMove);
        return opponentMove;
    }
}
