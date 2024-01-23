package com.behavioral.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject{
    List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer obs) {
        this.subscribers.add(obs);
    }

    @Override
    public void unsubscribe(Observer obs) {
        this.subscribers.remove(obs);
    }

    @Override
    public void newVideoUploaded(String title) {
        for(Observer obs:this.subscribers){
            obs.notified(title);
        }
    }
}
