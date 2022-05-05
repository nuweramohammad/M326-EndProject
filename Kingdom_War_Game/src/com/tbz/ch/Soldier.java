package com.tbz.ch;

import java.util.Random;

public class Soldier extends RequestHandler {
    private String name = "Soldier";


    public Soldier(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handleRequest(Instruction request) {
       if (Command.SHOOTING_PRACTICE == request.getCommand() || Command.STAMINA_EXERCISES == request.getCommand()){
           System.out.println(this.name + " Handle request: "+ request);
           request.markHandled();
       }else{
           System.out.println("Not a request for the Soldier");
       }
    }



    public int fight(){
        int counter = 0;

        return counter;
    }

}
