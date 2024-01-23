package com.behavioral.chain_of_responsibility;

public class ErrorBasedLogger extends Logger{
    public ErrorBasedLogger(int levels) {
        this.levels=levels;
    }
    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("ERROR LOGGER INFO: "+msg);
    }
}
