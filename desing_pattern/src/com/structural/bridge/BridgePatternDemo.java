package com.structural.bridge;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Engine engine1= new Petrol();
        Vehicle car = new Car(engine1);
        car.refill();

        Engine engine2= new Electric();
        Vehicle bike = new Bike(engine2);
        bike.refill();
    }
}
