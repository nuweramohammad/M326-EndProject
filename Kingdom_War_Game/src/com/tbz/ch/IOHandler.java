package com.tbz.ch;

import java.util.Scanner;


public class IOHandler {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    private final Scanner scan = new Scanner(System.in);
    private Queue queue;
    private Validation validate = new Validation();
    private King king = new King();
    private Soldier soldier = new Soldier();


    public void chooseRole() {
        int answer = 0;
        while (answer != 6) {
            printRoleMenu();
            do {

                System.out.println("Choose your role:");
                System.out.print("> ");
                answer = validate.validateIntInput();
            } while (answer > 6 || answer < 1);

            switch (answer) {
                case 1 -> {
                    printKingsMenu();
                    break;
                }
                case 2 -> {
                    printSoldiersMenu();
                    break;
                }
                case 3 -> {
                    //todo minister menu
                    System.out.println("Minister Menu...");
                    break;
                }
                case 4 -> {
                    printCommandersMenu();
                    break;
                }
                case 5 -> {
                    printCitizensMenu();
                    break;
                }
                case 6 -> {
                    System.out.println("Exit Program");
                    break;
                }

            }
        }
    }

    public void printRoleMenu() {
        System.out.println(BLUE + "\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1. King                 │     │2. Soldier              │     │3. Minister             │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯");
        System.out.println("╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│4. Commander            │     │5. Citizen              │     │6. Exit                 │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯" + RESET);

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
        switch (answer) {
            case 1:
                System.out.println("AK Kingdom was the biggest kingdom in the subregion of europe. Tho they succeeded in all of their wars the still got their biggest enemy left to defeat. Now it is time to play THE GAME");
                break;
            case 2:
                System.out.println("NM Kingdom was the biggest kingdom in the western of europe. They defeated all of their neighboring countries, well.. except for one. Now that you have decided to join this empire... FIGHT and acknowledge this kingdom as yours..");
                break;
            default:
                System.out.println("Ohhps wrong spot here");
        }
    }


    public void printKingsMenu() {
        System.out.println(BLUE + "\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮      ╭────────────────────────╮");
        System.out.println("│1. Check Bank balance   │     │2. Check army           │     │3. Give instruction     │        │4. Go back              │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯        ╰────────────────────────╯" + RESET);
        kingsRole();
    }


    public void kingsRole() {
        int answer = 0;
        while (answer != 4) {
            System.out.print("> ");

            answer = validate.validateIntInput();
            switch (answer) {
                case 1:
                case 2:
                    soldier.fight(false);
                    break;
                case 3:
                    giveInstruction();
                    break;
                case 4:
                    System.out.println("Going back...");
                    break;
                default:
                    System.out.println("Not valid \n Try again: \n > ");
                    break;
            }
        }
    }

    public Instruction giveInstruction() {
        Command[] command = Command.values();
        for (Command c : command) {
            System.out.println(c);
        }
        System.out.println("Choose from the list above: ");
        System.out.print("> ");
        String answer = scan.nextLine();
        Instruction instruction = new Instruction(Command.valueOf(answer), printInstructionDescription(answer));

        if (Command.getCommands().toString().contains(answer)) {
            king.makeRequest(instruction);
        } else {
            // TODO: 09.05.2022 Validation
            System.out.println("This commands was not in the list. \nTry again king: \n > ");
            //answer = scan.nextLine();

        }
        return instruction;
    }


    public void printSoldiersMenu() {
        System.out.println(BLUE + "\n╭────────────────────────╮     ╭────────────────────────╮      ╭────────────────────────╮");
        System.out.println("│1. Start Fight          │     │2. Check Notification   │       │3. Go back              │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯       ╰────────────────────────╯" + RESET);
        soldierRole();
    }

    public void soldierRole() {
        int answer = 0;
        answer = validate.validateIntInput();
        do {
            switch (answer) {
                case 1:
                    soldier.fight(true);
                    break;
                case 2:
                    // soldier.handleRequest();
                    break;
                default:
                    System.out.println("Invalid answer, choose from the menu above \n > ");
                    break;
            }
        } while (answer < 1 || answer > 2);
    }


    public void printCitizensMenu() {
        System.out.println(BLUE + "\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮       ╭────────────────────────╮");
        System.out.println("│1.     Protest          │     │2. Start Spending       │     │3. Start Saving         │        │4. Go back              │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯        ╰────────────────────────╯" + RESET);
    }


    public void printCommandersMenu() {
        System.out.println(BLUE + "\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮   ╭────────────────────────╮");
        System.out.println("│1.     Parkour          │     │2. Stamina Exercises    │     │3. Shooting Practice    │    │4. Go back              │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯    ╰────────────────────────╯" + RESET);
    }

    public String printInstructionDescription(String command) {
        String description = "";
        switch (command) {
            case "COLLECT_TAX" -> description = "Collect 5% of income as tax";
            case "PROTEST" -> description = "Go Protest for your king";
            case "SHOOTING_PRACTICE" -> description = "Get ready to start shooting";
            case "STAMINA_EXERCISES" -> description = "Lets work on those abs";
            case "START_SAVING" -> description = "Keep the money you earn for yourself";
            case "START_SPENDING" -> description = "Help your state by spending your income!";
        }
        System.out.println(description);
        return description;
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