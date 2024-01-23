package com.behavioral.strategy_pattern;

public class StrategyPatternDemo {

    public static void main(String[] args) {
        Context context = new Context(new Addition());
        System.out.println(context.executeStrategy(10.0f,5.0f));

        context= new Context(new Subtraction());
        System.out.println(context.executeStrategy(10.0f,5.0f));

        context= new Context(new Multiplication());
        System.out.println(context.executeStrategy(10.0f,5.0f));

    }
}
