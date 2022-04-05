package com.tbz.ch;

public abstract class RequestHandler {
    private RequestHandler nextRequest;
    private int count;

    public void handleRequest(){};
    public int handleWin(){
        return count;
    }
}
