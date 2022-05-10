package com.tbz.ch;

public abstract class RequestHandler {
    private RequestHandler nextRequest;

    public RequestHandler(RequestHandler nextRequest) {
        this.nextRequest = nextRequest;
    }

    public RequestHandler() {
    }

    public void handleRequest(Instruction request) {
        if (nextRequest != null) {
            nextRequest.handleRequest(request);
        }
    }

    public void checkNotification(Instruction instruction) {
    }


}
