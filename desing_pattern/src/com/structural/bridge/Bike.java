package com.structural.bridge;

public class Bike extends Vehicle{

    public Bike(Engine engine) {
        super(engine);
    }

    @Override
    public void refill() {
        System.out.println("Bike: "+engine.refill());
    }
}
