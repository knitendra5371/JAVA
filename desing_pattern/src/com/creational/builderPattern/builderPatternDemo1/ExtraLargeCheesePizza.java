package com.creational.builderPattern.builderPatternDemo1;

public class ExtraLargeCheesePizza extends VegPizza{
    @Override
    public float price() {
        return 300.f;
    }
    @Override
    public String name() {
        return  "Cheese Pizza";
    }
    @Override
    public String size() {
        return "Extra-Large Size";
    }
}
