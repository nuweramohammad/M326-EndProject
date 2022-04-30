package com.tbz.ch;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
    Scanner scan = new Scanner(System.in);

    public String validateStringInput() {
        return "";
    }

    /**
     * This method checks for an input
     * which can only be a double (decimal number)
     * if not a error occurs and the user
     * is requested to try again
     *
     * @return input
     */
    public int validateIntInput() {
        String answer = scan.nextLine();
        String intPattern = "\\d";
        boolean match = Pattern.matches(intPattern, answer);
        while (!match) {
            if (!answer.matches(intPattern)) {
                System.out.println(IOHandler.RED + "Not valid, try again: \n > " + IOHandler.RESET);
                answer = scan.nextLine();
            } else {
                match = true;
            }
        }
        return Integer.parseInt(answer);
    }

    public int validateCharacterLength() {
        return 0;
    }
}
