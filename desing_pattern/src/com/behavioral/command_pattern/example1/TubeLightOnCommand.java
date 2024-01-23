package com.behavioral.command_pattern.example1;

public class TubeLightOnCommand implements Command{
    TubeLight tubeLight;

    public TubeLightOnCommand(TubeLight tubeLight) {
        this.tubeLight = tubeLight;
    }

    @Override
    public void execute() {
        tubeLight.switchOn();
    }
}
