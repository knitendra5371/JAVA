package com.behavioral.command_pattern.example2;

public class CommandPatternDemo {
    public static void main(String[] args) {
        Document doc = new Document();

        ActionListenerCommand actionOpen = new ActionOpen(doc);
        ActionListenerCommand actionSave = new ActionSave(doc);

        MenuOptions menu = new MenuOptions(actionOpen, actionSave);

        menu.clickOpen();
        menu.clickSave();
    }
}
