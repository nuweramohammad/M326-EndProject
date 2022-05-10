package com.tbz.ch;

import java.util.Scanner;

public class  Citizen extends RequestHandler{
    private Scanner scanner = new Scanner(System.in);

    public Citizen(RequestHandler nextRequest) {
        super(nextRequest);
    }

    public Citizen() {}

    @Override
    public void handleRequest(Instruction request) {
        if(Command.PROTEST == request.getCommand() || Command.START_SPENDING == request.getCommand() || Command.START_SAVING == request.getCommand()){
            System.out.println("Passing Command to Citizen; " + request);
            request.markHandled();
        }else{
            System.out.println("Nothing the citizen could do");
        }
    }

    @Override
    public void checkNotification(Instruction instruction) {
        if (instruction.getCommand().equals(Command.PROTEST)){
            System.out.println("Would you like to protest? \n > ");
            String answer = scanner.nextLine();
            if (answer.equals("yes")){
                System.out.println(instruction.getCommandDescription());
            }else if(answer.equals("no")){
                System.out.println("Nothing new");
            }
        }else if(instruction.getCommand().equals(Command.START_SAVING) || instruction.getCommand().equals(Command.START_SPENDING)){
            System.out.println(instruction.getCommandDescription());
        }else{
            System.out.println("No notification");
        }
    }
}