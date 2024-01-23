package com.behavioral.template_pattern.example2;

public class TemplatePatternDemo {
    public static void main(String[] args) {

        OrderProcessTemplate orderProcessTemplate = new StoreOrder();
        orderProcessTemplate.processOrder();

        System.out.println("================================\n");

        orderProcessTemplate= new OnlineOrder();
        orderProcessTemplate.isGiftWrap=true;
        orderProcessTemplate.processOrder();
    }
}
