package com.example07;

import java.util.function.Consumer;

public class ActionDelete implements Consumer<EditorEvent> {
    @Override
    public void accept(EditorEvent editorEvent) {
        //perform delete action on objects from event
    }
}
