package com.tbz.ch;

public class Minister extends RequestHandler {

    public Minister(RequestHandler nextRequest) {
        super(nextRequest);
    }

    @Override
    public void handleRequest(Instruction request) {
        if (Command.COLLECT_TAX == request.getCommand()) {
            System.out.println("Minister Handle request: " + request);
            request.markHandled();
        } else if (Command.PROTEST == request.getCommand() || Command.START_SAVING == request.getCommand() || Command.START_SPENDING == request.getCommand()) {
            super.handleRequest(request);
        }else{
            System.out.println("Not accepting");
        }
    }
}
