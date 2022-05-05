package com.tbz.ch;

import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOHandler {
    private Queue queue;
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    private final Scanner scan = new Scanner(System.in);
    private Validation validate = new Validation();
    private King king = new King();


    public void chooseRole() {
        int answer = validate.validateIntInput();
        switch (answer) {
            case 1:
                printKingsMenu();
                break;
            case 2:
                printSoldiersMenu();
                break;
            case 3:
                //todo minister menu
                System.out.println("Minister Menu...");
                break;
            case 4:
                printCommandersMenu();
                break;
            case 5:
                printCitizensMenu();
                break;
            default:
                System.out.println("Invalid answer, Number has to be between 1 and 5 \n > ");
                break;
        }
    }

    public void printRoleMenu() {
        System.out.println(BLUE + "\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1. King                 │     │2. Soldier              │     │3. Minister             │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯");
        System.out.println("╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│4. Commander            │     │5. Citizen              │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯" + RESET);
        System.out.println("Choose your role:");
        System.out.print("> ");
    }

    public void printInstigation() {
        int answer = 0;
        System.out.println(GREEN + "Hello to the sad dual of the AK Kingdom and the NM Kingdom. This war has been going on for decades. Now it is up to you to decide" +
                "their faith..." + RED + "\nLET THE GAME BEGIN.. WHO DO YOU WANT TO FIGHT FOR?!" + GREEN + "\nIf you want to exit the game you can press 0 at any time of the game" + RESET);
        System.out.println(RED + "╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1. AK KINGDOM           │     │2. NM KINGDOM           │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯" + RESET);
        do {
            System.out.print("> ");
            answer = validate.validateIntInput();
        } while (answer < 1 || answer > 2);
    }


    public void printKingsMenu() {
        System.out.println(BLUE + "\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1. Check Bank balance       │     │2. Check army           │     │3. Give instruction     │");
        System.out.println("╰────────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯" + RESET);
        kingsRole(new Instruction(Command.COLLECT_TAX, "collect 5% of income as tax"));
    }

    public void kingsRole(Instruction instruction) {
        int answer = 0;
        answer = validate.validateIntInput();
        switch (answer) {
            case 1:
                System.out.println("check balance");
                break;
            case 2:
                System.out.println("check army");
                break;
            case 3:
                List<String> commandList = EnumSet.allOf(Command.class).stream().map(Command::name).collect(Collectors.toList());
                String commandAnswer = "";
                while (!commandList.contains(commandAnswer)) {
                    System.out.println(commandList);
                    System.out.println("> ");
                    commandAnswer = scan.nextLine();
                    if (commandList.contains(commandAnswer)) {
                        king.makeRequest(instruction);
                    } else {
                        System.out.print("No such command found \n Try again: \n > ");
                        commandAnswer = scan.nextLine();
                    }
                }
                break;
            default:
                System.out.println("Not valid \n Try again: \n > ");
                break;
        }

    }

    public void printSoldiersMenu() {
        System.out.println(BLUE + "\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1. Shoot                │     │2. Defend               │     │3. Check Notification   │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯" + RESET);
        soldierRole();
    }

    public void soldierRole() {
        int answer = 0;
        answer = validate.validateIntInput();
        do {
            switch (answer) {
                case 1:
                    System.out.println("shoot");
                    break;
                case 2:
                    System.out.println("defend");
                    break;
                default:
                    System.out.println("Invalid answer, choose from the menu above \n > ");
                    break;
            }
        } while (answer < 1 || answer > 2);
    }


    public void printCitizensMenu() {
        System.out.println(BLUE + "\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1.     Protest          │     │2. Start Spending       │     │3. Start Saving         │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯" + RESET);
    }


    public void printCommandersMenu() {
        System.out.println(BLUE + "\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1.     Parkour          │     │2. Stamina Exercises    │     │3. Shooting Practice    │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯" + RESET);
    }


    /**
     * This method prints a nice output to
     * tell the user goodbye:)
     */
    public void printGoodBye() {
        System.out.println("""
                                                                                             \s
                                                           8I   ,dPYb,                       \s
                                                           8I   IP'`Yb                       \s
                                                           8I   I8  8I                       \s
                                                           8I   I8  8'                       \s
                   ,gggg,gg    ,ggggg,    ,ggggg,    ,gggg,8I   I8 dP      gg     gg   ,ggg, \s
                  dP"  "Y8I   dP"  "Y8gggdP"  "Y8gggdP"  "Y8I   I8dP   88ggI8     8I  i8" "8i\s
                 i8'    ,8I  i8'    ,8I i8'    ,8I i8'    ,8I   I8P    8I  I8,   ,8I  I8, ,8I\s
                ,d8,   ,d8I ,d8,   ,d8',d8,   ,d8',d8,   ,d8b, ,d8b,  ,8I ,d8b, ,d8I  `YbadP'\s
                P"Y8888P"888P"Y8888P"  P"Y8888P"  P"Y8888P"`Y8 8P'"Y88P"' P""Y88P"888888P"Y888
                       ,d8I'                                                    ,d8I'        \s
                     ,dP'8I                                                   ,dP'8I         \s
                    ,8"  8I                                                  ,8"  8I         \s
                    I8   8I                                                  I8   8I         \s
                    `8, ,8I                                                  `8, ,8I         \s
                     `Y8P"                                                    `Y8P" \s""");
    }
}