package com.creational.builderPattern.builderPatternDemo1;

import java.io.IOException;

public class PizzaHutDemo {
    public static void main(String[] args) throws IOException {
        OrderBuilder builder=new OrderBuilder();

        OrderedItems orderedItems = builder.preparePizza();

        orderedItems.showItems();

        System.out.println("\n");
        System.out.println("Total Cost : "+ orderedItems.getCost());
    }
}
