package com.example07;

import java.util.function.Consumer;

public class ActionJoin implements Consumer<EditorEvent> {
    @Override
    public void accept(EditorEvent editorEvent) {
        //perform join action on objects from event
    }
}
