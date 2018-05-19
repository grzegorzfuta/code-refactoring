package com.example07;

import lombok.Data;

@Data
public class EditorEvent {

    private EditorObject source;
    private EditorObject destination;

}
