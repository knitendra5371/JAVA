package com.behavioral.state_pattern;

public class GoldState implements State{
    @Override
    public void getBenefits() {
        System.out.println("==============================================================\n");
        System.out.println("Account is in Gold state. Your benefits are listed below.");
        System.out.println("15% off on groceries with the use of debit card");
        System.out.println("20% off on beauty products with the use of debit card");
        System.out.println("==============================================================\n");
    }
}
