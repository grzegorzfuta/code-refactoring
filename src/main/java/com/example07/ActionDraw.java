package com.example07;

import java.util.function.Consumer;

public class ActionDraw implements Consumer<EditorEvent> {
    @Override
    public void accept(EditorEvent editorEvent) {
        //perform draw action on objects from event
    }
}
