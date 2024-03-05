package com.creational.builderPattern.builderPatternDemo1;

public class SmallNonVegPizza extends NonVegPizza{
    @Override
    public float price() {
        return 180.0f;
    }

    @Override
    public String name() {
        return "Non-Veg Pizza";
    }

    @Override
    public String size() {
        return "Samll Size";
    }
}
