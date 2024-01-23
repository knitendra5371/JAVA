package com.behavioral.command_pattern.example2;

public class ActionSave implements ActionListenerCommand{
    private Document doc;
    public ActionSave(Document doc) {
        this.doc = doc;
    }
    @Override
    public void execute() {
        doc.save();
    }
}
