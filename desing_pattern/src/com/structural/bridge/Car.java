package com.structural.bridge;

public class Car extends Vehicle{

    public Car(Engine engine) {
        super(engine);
    }

    @Override
    public void refill() {
        System.out.println("Car: "+engine.refill());
    }
}
