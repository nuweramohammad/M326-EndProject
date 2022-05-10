package com.tbz.ch;

import java.util.Scanner;

public class Commander extends RequestHandler{
    Scanner scanner = new Scanner(System.in);

    public Commander(RequestHandler nextRequest) {
        super(nextRequest);
    }

    public Commander() {}

    /**
     * This method is inherited from the Request Handler and checks
     * if it's something for the commander the description of the command
     * is printed and if it's something for the soldiers it automatically
     * passes the command
     * @param request
     */
    @Override
    public void handleRequest(Instruction request) {
        if (Command.SHOOTING_PRACTICE == request.getCommand() || Command.STAMINA_EXERCISES == request.getCommand()){
            System.out.println("Passing Command to Commander; " + request);
            super.handleRequest(request);
            request.markHandled();
        }else{
            System.out.println("Can't be passed, not a command for the commander");
        }
    }

    /**
     * The commander is the head of the army
     * that's he can make new commands which are
     * saved in the arraylist of enums from the Command
     * Class
     */
    public void addNewCommand(){
        System.out.println("What should be your command sir? \n> ");

        String answer = scanner.nextLine();
    }

    /**
     * If the king makes a command and if the following
     * Command is mentioned the Commander can check for notifications
     * in his menu. If nothing new arrived he will get a "No Notification"
     * message
     * @param instruction
     */
    @Override
    public void checkNotification(Instruction instruction){
        if(instruction.getCommand().equals(Command.SHOOTING_PRACTICE) || instruction.getCommand().equals(Command.STAMINA_EXERCISES)){
            System.out.println(instruction.getCommandDescription());
        }else{
            System.out.println("No notifications");
        }
    }
}
