package com.behavioral.observer_pattern;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject channel = new YoutubeChannel();
        Observer observer1 = new Subscriber("Aman");
        channel.subscribe(observer1);
        channel.subscribe(new Subscriber("Nitendra"));
        channel.subscribe(new Subscriber("Ramendra"));
        channel.newVideoUploaded("Learn Design Pattern");
        channel.unsubscribe(observer1);
        channel.newVideoUploaded("Learn Python");
    }
}
