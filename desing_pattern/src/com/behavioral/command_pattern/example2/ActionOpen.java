package com.behavioral.command_pattern.example2;

public class ActionOpen implements ActionListenerCommand{
    private Document doc;
    public ActionOpen(Document doc) {
        this.doc = doc;
    }
    @Override
    public void execute() {
        doc.open();
    }
}
