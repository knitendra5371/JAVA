package com.structural.bridge;

public abstract class Vehicle {
    public Engine engine;

    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    public abstract void refill();
}
