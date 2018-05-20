package com.example07;

import java.util.function.Consumer;

public class ActionModify implements Consumer<EditorEvent> {
    @Override
    public void accept(EditorEvent editorEvent) {
        //perform modify action on objects from event
    }
}
