package com.behavioral.command_pattern.example2;

public class MenuOptions {
    ActionListenerCommand actionOpen;
    ActionListenerCommand actionSave;

    public MenuOptions(ActionListenerCommand actionOpen, ActionListenerCommand actionSave) {
        this.actionOpen = actionOpen;
        this.actionSave = actionSave;
    }

    void clickOpen(){
        actionOpen.execute();
    }
    void clickSave(){
        actionSave.execute();
    }

}
