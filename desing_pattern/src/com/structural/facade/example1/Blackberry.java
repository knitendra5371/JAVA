package com.structural.facade.example1;

public class Blackberry implements Mobile{
    @Override
    public void modelNo() {
        System.out.println(" Blackberry Z10 ");
    }
    @Override
    public void price() {
        System.out.println(" Rs 55000.00 ");
    }
}
