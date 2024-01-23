package com.behavioral.state_pattern;

public class PlatinumState implements State{
    @Override
    public void getBenefits() {
        System.out.println("==============================================================\n");
        System.out.println("Account is in Platinum state. Your benefits are listed below.");
        System.out.println("20% off on groceries with the use of debit card");
        System.out.println("25% off on beauty products with the use of debit card");
        System.out.println("==============================================================\n");
    }
}
