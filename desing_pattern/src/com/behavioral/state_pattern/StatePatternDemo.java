package com.behavioral.state_pattern;

public class StatePatternDemo {
    public static void main(String[] args) {
        Account account = new Account(3000);
        account.getCurrentBenefits();

        account.deposite(3000);
        account.getCurrentBenefits();

        account.deposite(8000);
        account.getCurrentBenefits();

        account.withdrow(10000);
        account.getCurrentBenefits();
    }
}
