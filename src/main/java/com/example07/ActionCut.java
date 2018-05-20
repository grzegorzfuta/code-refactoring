package com.example07;

import java.util.function.Consumer;

public class ActionCut implements Consumer<EditorEvent> {
    @Override
    public void accept(EditorEvent editorEvent) {
        //perform cut action on objects from event
    }
}
