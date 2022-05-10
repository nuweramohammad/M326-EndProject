package com.tbz.ch;

public class Minister extends RequestHandler {

    public Minister(RequestHandler nextRequest) {
        super(nextRequest);
    }

    /**
     * This method is inherited from the Request Handler and checks
     * if it's something for the minster the description of the command
     * is printed else it checks any relation to the citizen, if it's
     * there the command is also passed down to the citizens
     * @param request
     */
    @Override
    public void handleRequest(Instruction request) {
        if (Command.COLLECT_TAX == request.getCommand()) {
            System.out.println("Passing Command to Minister; " + request);
            request.markHandled();
        } else if (Command.PROTEST == request.getCommand() || Command.START_SAVING == request.getCommand() || Command.START_SPENDING == request.getCommand()) {
            super.handleRequest(request);
        }else{
            System.out.println("Can't be passed, not a command for the minister");
        }
    }

    /**
     * If the king makes a command and if the following
     * Command is mentioned the minister can check for notifications
     * in his menu. If nothing new arrived he will get a "No Notification"
     * message
     * @param instruction
     */
    @Override
    public void checkNotification(Instruction instruction){
        if(instruction.getCommand().equals(Command.COLLECT_TAX)){
            System.out.println(instruction.getCommandDescription());
        }else{
            System.out.println("No notifications");
        }
    }
}
