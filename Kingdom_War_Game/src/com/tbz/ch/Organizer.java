package com.tbz.ch;
public class Organizer {
    private IOHandler ioHandler = new IOHandler();
    public void run(){
        ioHandler.printInstigation();
        ioHandler.printRoleMenu();
        ioHandler.chooseRole();

        ioHandler.printGoodBye();
    };
}