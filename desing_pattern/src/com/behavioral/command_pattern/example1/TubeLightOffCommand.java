package com.behavioral.command_pattern.example1;

public class TubeLightOffCommand implements Command{
    TubeLight tubeLight;

    public TubeLightOffCommand(TubeLight tubeLight) {
        this.tubeLight = tubeLight;
    }

    @Override
    public void execute() {
        tubeLight.switchOff();
    }
}
