package com.structural.facade.example2;

public class HomeTheater {
    private RoomLights roomLights;
    private SoundSystem soundSystem;
    private Television television;

    public HomeTheater(RoomLights roomLights, SoundSystem soundSystem, Television television) {
        this.roomLights = roomLights;
        this.soundSystem = soundSystem;
        this.television = television;
    }

    public void watchMovie(){ // here we are calling some methods internally   i.e. encapsulating the methods
        roomLights.dimLight();
        soundSystem.onSoundSystem();
        television.onTelevision();
    }

    public void stopWatchingMovie(){
        roomLights.brightLight();
        television.offTelevision();
        soundSystem.offSoundSystem();
    }
}
