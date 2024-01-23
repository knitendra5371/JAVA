package com.behavioral.observer_pattern;

public interface Subject {
    void subscribe(Observer obs);
    void unsubscribe(Observer obs);
    void newVideoUploaded(String title);
}
