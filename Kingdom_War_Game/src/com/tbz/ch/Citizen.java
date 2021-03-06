package com.tbz.ch;

public class  Citizen extends RequestHandler{



    public Citizen(RequestHandler nextRequest) {
        super(nextRequest);
    }

    @Override
    public void handleRequest(Instruction request) {
        if(Command.PROTEST == request.getCommand() || Command.START_SPENDING == request.getCommand() || Command.START_SAVING == request.getCommand()){
            System.out.println("New Notification: " + request);
            request.markHandled();
        }else{
            System.out.println("Nothing the citizen could do");
        }
    }
}