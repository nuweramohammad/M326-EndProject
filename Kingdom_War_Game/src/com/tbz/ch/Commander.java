package com.tbz.ch;

public class Commander extends RequestHandler{
    private String name = "Commander";
    Notification notification = new Notification();

    public Commander(RequestHandler nextRequest) {
        super(nextRequest);
    }

    @Override
    public void handleRequest(Instruction request) {
        if (Command.SHOOTING_PRACTICE == request.getCommand() || Command.STAMINA_EXERCISES == request.getCommand()){
            System.out.println(this.name + " Request: " + request);
            request.markHandled();
        }else{
            super.handleRequest(request);
        }
    }
}
