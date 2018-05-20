package com.example07;

import java.util.function.Consumer;

public class ActionAdd implements Consumer<EditorEvent> {
    @Override
    public void accept(EditorEvent editorEvent) {
        //perform add action on objects from event
    }
}
