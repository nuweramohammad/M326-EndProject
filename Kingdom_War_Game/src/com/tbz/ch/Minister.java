package com.tbz.ch;

public class Minister extends RequestHandler{
    Notification notification = new Notification();
    private String name = "Minister";

    public Minister(RequestHandler nextRequest) {
        super(nextRequest);
    }

    @Override
    public void handleRequest(Instruction request) {
        if(Command.COLLECT_TAX == request.getCommand()){
            System.out.println(this.name + " Handle request: "+ request);
            request.markHandled();
        }else {
            super.handleRequest(request);
        }    }
}
