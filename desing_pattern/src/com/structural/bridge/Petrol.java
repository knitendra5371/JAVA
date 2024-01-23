package com.structural.bridge;

public class Petrol implements Engine{
    @Override
    public String refill() {
        return "Refueled engine 5 liters";
    }
}
