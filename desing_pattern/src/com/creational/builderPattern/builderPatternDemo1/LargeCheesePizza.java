package com.creational.builderPattern.builderPatternDemo1;

public class LargeCheesePizza extends VegPizza{
    @Override
    public float price() {
        return 260.0f;
    }
    @Override
    public String name() {
        return "Cheese Pizza";
    }
    @Override
    public String size() {
        return "Large Size";
    }
}
