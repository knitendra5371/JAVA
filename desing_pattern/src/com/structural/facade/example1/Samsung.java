package com.structural.facade.example1;

public class Samsung implements Mobile{
    @Override
    public void modelNo() {
        System.out.println(" Samsung galaxy tab 3 ");
    }
    @Override
    public void price() {
        System.out.println(" Rs 45000.00 ");
    }
}
