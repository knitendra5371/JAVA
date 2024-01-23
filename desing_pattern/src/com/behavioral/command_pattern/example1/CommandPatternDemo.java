package com.behavioral.command_pattern.example1;

public class CommandPatternDemo {
    public static void main(String[] args) {
        TubeLight tubeLight = new TubeLight();
        RemoteController remoteController = new RemoteController(new TubeLightOnCommand(tubeLight));
        remoteController.pressButton();

        System.out.println("==========================");

        remoteController.setCommand(new TubeLightOffCommand(tubeLight));
        remoteController.pressButton();
    }
}
