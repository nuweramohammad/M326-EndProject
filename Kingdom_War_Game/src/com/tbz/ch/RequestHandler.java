package com.tbz.ch;

public abstract class RequestHandler {
    private RequestHandler nextRequest;
    private int count;

    public RequestHandler(RequestHandler nextRequest) {
        this.nextRequest = nextRequest;
    }

    public RequestHandler() {

    }

    public void handleRequest(Instruction request){
        if (nextRequest != null){
            nextRequest.handleRequest(request);
        }
    }
    public int handleWin(){
        return count;
    }
}
