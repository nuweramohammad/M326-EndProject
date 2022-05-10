package com.tbz.ch;

import java.util.Scanner;

public class Commander extends RequestHandler{
    Scanner scanner = new Scanner(System.in);

    public Commander(RequestHandler nextRequest) {
        super(nextRequest);
    }

    public Commander() {}

    @Override
    public void handleRequest(Instruction request) {
        if (Command.SHOOTING_PRACTICE == request.getCommand() || Command.STAMINA_EXERCISES == request.getCommand()){
            System.out.println("Passing Command to Commander; " + request);
            super.handleRequest(request);
            request.markHandled();
        }else{
            System.out.println("Not accepting");
        }
    }

    public void addNewCommand(){
        System.out.println("What should be your command sir? \n> ");

        String answer = scanner.nextLine();
    }

    @Override
    public void checkNotification(Instruction instruction){
        if(instruction.getCommand().equals(Command.SHOOTING_PRACTICE) || instruction.getCommand().equals(Command.STAMINA_EXERCISES)){
            System.out.println(instruction.getCommandDescription());
        }else{
            System.out.println("No notifications");
        }
    }
}
