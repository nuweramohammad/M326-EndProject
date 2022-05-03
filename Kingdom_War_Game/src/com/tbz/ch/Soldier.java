package com.tbz.ch;

import java.util.Random;

public class Soldier extends RequestHandler {
    private String name = "Soldier";
    Notification notification = new Notification();

    public Soldier(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handleRequest(Instruction request) {
       if (Command.SHOOTING_PRACTICE == request.getCommand()){
           System.out.println(this.name + "Handle request: "+ request);
           request.markHandled();
       }else{
           super.handleRequest(request);
       }
    }



    public int fight(){
        int counter = 0;

        return counter;
    }

}
