package com.tbz.ch;

import java.util.concurrent.BlockingQueue;

public class Queue {
    private RequestHandler request;
    private BlockingQueue<Instruction> queue;
    Thread thread = new Thread();

    public void put(){};
    public void take(){};

}
