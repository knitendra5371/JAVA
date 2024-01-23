package com.structural.bridge;

public class Electric implements Engine{
    @Override
    public String refill() {
        return "Charged engine to 100%";
    }
}
