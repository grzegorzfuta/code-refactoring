package com.example07;

import lombok.Data;

@Data
public class EditorEvent {

    private final EditorObject source;
    private final EditorObject destination;

}
