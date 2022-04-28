package com.tbz.ch;

import java.util.Scanner;

public class IOHandler {
    private Queue queue;
    private  final String RESET = "\u001B[0m";
    private  final String RED = "\u001B[31m";
    private  final String GREEN = "\u001B[32m";
    private  final String BLUE = "\u001B[34m";
    private final Scanner scan = new Scanner(System.in);


    public void start(){
        int answer = 0;
        printInstigation();
        answer = scan.nextInt();

    }

    public void printMainMenu(){
        System.out.println(BLUE+"\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1. King                 │     │2. Soldier              │     │3. Minister             │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯");
        System.out.println("╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│4. Commander            │     │5. Citizen              │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯" +RESET);
    };

    public void printInstigation(){
        System.out.println(GREEN+"Hello to the sad dual of the AK Kingdom and the NM Kingdom. This war has been going on for decades. Now it is up to you to decide" +
                "their faith..."+ RED +"\nLET THE GAME BEGIN.. WHO DO YOU WANT TO FIGHT FOR?!");
        System.out.println("╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1. AK KINGDOM           │     │2. NM KINGDOM          │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯"+RESET);
        System.out.println("> ");

    }

    public void printKingsMenu(){
        System.out.println(BLUE+"\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1.            #C1       │     │2. #C2                  │     │3. #     C3             │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯"+RESET);
    };

    public void printSoldiersMenu(){
        System.out.println(BLUE+"\n╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1.     Shoot            │     │2. Defend               │ ");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯ "+RESET);
    };

    public void printCitizensMenu(){
        System.out.println(BLUE+"\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1.     Protest          │     │2. Start Spending       │     │3. Start Saving         │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯"+RESET);
    };

    public void printCommandersMenu(){
        System.out.println(BLUE+"\n╭────────────────────────╮     ╭────────────────────────╮     ╭────────────────────────╮");
        System.out.println("│1.     Parkour          │     │2. Stamina Exercises    │     │3. Shooting Practice    │");
        System.out.println("╰────────────────────────╯     ╰────────────────────────╯     ╰────────────────────────╯"+RESET);
    };

    /**
     * This method prints a nice output to
     * tell the user goodbye:)
     */
    public  void printGoodBye(){
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
