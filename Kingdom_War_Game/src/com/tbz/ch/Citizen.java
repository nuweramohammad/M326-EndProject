package com.tbz.ch;

import java.util.Scanner;

public class  Citizen extends RequestHandler{
    private Scanner scanner = new Scanner(System.in);

    public Citizen(RequestHandler nextRequest) {
        super(nextRequest);
    }

    public Citizen() {}

    /**
     * This method is inherited from the Request Handler and checks
     * if it's something for the citizen the description of the command
     * is printed and else it can't be passed on because the chain
     * reaches to it's end
     * @param request
     */
    @Override
    public void handleRequest(Instruction request) {
        if(Command.PROTEST == request.getCommand() || Command.START_SPENDING == request.getCommand() || Command.START_SAVING == request.getCommand()){
            System.out.println("Passing Command to Citizen; " + request);
            request.markHandled();
        }else{
            System.out.println("Nothing the citizen could do");
        }
    }

    /**
     * If the king makes a command and if the following
     * Command is mentioned the Citizen can check for notifications
     * in his menu. If the king ever asks to protest
     * the citizen has a free will to either accept or decline it.
     * If nothing new arrived he will get a "No Notification"
     * message
     * @param instruction
     */
    @Override
    public void checkNotification(Instruction instruction) {
        if (instruction.getCommand().equals(Command.PROTEST)){
            System.out.print("Would you like to protest? \n > ");
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