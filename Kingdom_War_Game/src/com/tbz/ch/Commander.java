package com.tbz.ch;

public class Commander extends RequestHandler{


    public Commander(RequestHandler nextRequest) {
        super(nextRequest);
    }

    @Override
    public void handleRequest(Instruction request) {
        if (Command.SHOOTING_PRACTICE == request.getCommand() || Command.STAMINA_EXERCISES == request.getCommand()){
            System.out.println("Commander Request: " + request);
            super.handleRequest(request);
            request.markHandled();
        }else{
            System.out.println("Not accepting");
        }
    }

    public void addNewCommand(){
        System.out.println("adding command...");
    }
}
