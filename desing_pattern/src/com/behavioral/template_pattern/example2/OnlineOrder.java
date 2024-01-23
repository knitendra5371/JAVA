package com.behavioral.template_pattern.example2;

public class OnlineOrder extends OrderProcessTemplate{
    @Override
    protected void selectProduct() {
        System.out.println("Selecting procuct and adding to cart");
    }

    @Override
    protected void makePayment() {
        System.out.println("Making COD or online payment at wesite/app");
    }

    @Override
    protected void deliverProduct() {
        System.out.println("Product dispatched");
    }
}
