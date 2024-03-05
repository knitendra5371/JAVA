package com.creational.factoryMethod;

import java.util.Scanner;

public class FactoryPatternDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        GetPlanFactory planFactory = new GetPlanFactory();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter plan name ");
        Plan plan = planFactory.getPlan(scan.nextLine());
        plan.getRate();
        System.out.println("Enter number of units ");
        System.out.println("Bill = " + plan.getBill(scan.nextInt()));


    }

}
