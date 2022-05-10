package com.tbz.ch;

public abstract class RequestHandler {
    private RequestHandler nextRequest;

    public RequestHandler(RequestHandler nextRequest) {
        this.nextRequest = nextRequest;
    }

    public RequestHandler() {
    }

    /**
     * Checks for the next object in chain or
     * ends traversing if it's the last chain
     * for the object
     * @param request
     */
    public void handleRequest(Instruction request) {
        if (nextRequest != null) {
            nextRequest.handleRequest(request);
        }
    }

    /**
     * Every class that inherits Request Handler
     * uses this method specifically the different
     * roles in our program such as Citizen or Soldier.
     * With the help of this method, they can check
     * if any new Instruction is given from the king
     * @param instruction
     */
    public void checkNotification(Instruction instruction) {
    }


}
