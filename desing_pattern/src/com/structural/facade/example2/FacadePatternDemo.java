package com.structural.facade.example2;

public class FacadePatternDemo {
    public static void main(String[] args) {
        RoomLights roomLights = new RoomLights();
        Television television = new Television();
        SoundSystem soundSystem = new SoundSystem();
        HomeTheater homeTheater = new HomeTheater(roomLights,soundSystem,television);

        homeTheater.watchMovie();
        System.out.println("============");
        homeTheater.stopWatchingMovie();
    }
}
