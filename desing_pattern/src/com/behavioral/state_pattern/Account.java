package com.behavioral.state_pattern;

// this is a context class
public class Account {
    State state;
    double balance;

    Account(double balance) {
        this.balance = balance;
        this.state = new SilverState();
    }

    void deposite(double amount) {
        balance += amount;
        evaluateState();
    }

    void withdrow(double amount) {
        balance -= amount;
        evaluateState();
    }

    void getCurrentBenefits() {
        state.getBenefits();
    }

    void evaluateState() {
        if (balance <= 5000) {
            state = new SilverState();
        } else if (5000 < balance && balance <= 10000) {
            state = new GoldState();
        } else if (balance > 10000) {
            state = new PlatinumState();
        }
    }
}
