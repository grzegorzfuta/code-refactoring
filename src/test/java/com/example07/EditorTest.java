package com.example07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EditorTest {

    private Editor editor;

    @BeforeEach
    void setup() {
        editor = new Editor();
    }

    @Test
    void shouldSetDrawMode() {
        editor.setDrawMode();

        assertTrue(editor.isDrawMode());
        assertFalse(editor.isModifyMode());
        assertFalse(editor.isAddMode());
        assertFalse(editor.isDeleteMode());
        assertFalse(editor.isJoinMode());
        assertFalse(editor.isCutMode());
    }

    @Test
    void shouldSetModificationMode() {
        editor.setModificationMode();

        assertFalse(editor.isDrawMode());
        assertTrue(editor.isModifyMode());
        assertFalse(editor.isAddMode());
        assertFalse(editor.isDeleteMode());
        assertFalse(editor.isJoinMode());
        assertFalse(editor.isCutMode());
    }

    @Test
    void shouldSetAddMode() {
        editor.setAddMode();

        assertFalse(editor.isDrawMode());
        assertFalse(editor.isModifyMode());
        assertTrue(editor.isAddMode());
        assertFalse(editor.isDeleteMode());
        assertFalse(editor.isJoinMode());
        assertFalse(editor.isCutMode());
    }

    @Test
    void shouldSetDeleteMode() {
        editor.setDeleteMode();

        assertFalse(editor.isDrawMode());
        assertFalse(editor.isModifyMode());
        assertFalse(editor.isAddMode());
        assertTrue(editor.isDeleteMode());
        assertFalse(editor.isJoinMode());
        assertFalse(editor.isCutMode());
    }

    @Test
    void shouldSetJoinMode() {
        editor.setJoinMode();

        assertFalse(editor.isDrawMode());
        assertFalse(editor.isModifyMode());
        assertFalse(editor.isAddMode());
        assertFalse(editor.isDeleteMode());
        assertTrue(editor.isJoinMode());
        assertFalse(editor.isCutMode());
    }

    @Test
    void shouldSetCutMode() {
        editor.setCutMode();

        assertFalse(editor.isDrawMode());
        assertFalse(editor.isModifyMode());
        assertFalse(editor.isAddMode());
        assertFalse(editor.isDeleteMode());
        assertFalse(editor.isJoinMode());
        assertTrue(editor.isCutMode());
    }

    @Test
    void shouldHaveThreeEventsInHistory() {

    }

}
