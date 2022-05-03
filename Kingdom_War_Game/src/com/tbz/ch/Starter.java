package com.tbz.ch;

import java.util.Random;

public class Starter {
    public static void main(String[] args) {
        King king = new King();
        king.makeRequest(new Instruction(Command.COLLECT_TAX, "collect 5% of income as tax"));
        king.makeRequest(new Instruction(Command.SHOOTING_PRACTICE, "shooting practice starts at 5pm"));
        Organizer organizer = new Organizer();
        organizer.run();

    }
}
