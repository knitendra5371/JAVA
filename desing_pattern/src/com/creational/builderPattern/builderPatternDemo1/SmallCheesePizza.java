package com.creational.builderPattern.builderPatternDemo1;

public class SmallCheesePizza extends VegPizza{
    @Override
    public float price() {
        return 170.0f;
    }
    @Override
    public String name() {
        return "Cheese Pizza";
    }
    @Override
    public String size() {
        return "Small size";
    }
}
