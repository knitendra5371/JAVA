package com.creational.builderPattern.builderPatternDemo1;

public class MediumCheesePizza extends VegPizza{
    @Override
    public float price() {
        return  220.f;
    }
    @Override
    public String name() {
        return "Cheese Pizza";
    }
    @Override
    public String size() {
        return "Medium Size";
    }
}
