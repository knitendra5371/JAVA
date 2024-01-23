package com.structural.adapter;
/*
this is a client class
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {

        CreaditCard creaditCard = new BankCustomer();
        creaditCard.giveBabkDetails();
        creaditCard.getCreditCard();
    }
}
