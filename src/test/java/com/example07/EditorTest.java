package com.example07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EditorTest {

    private static final String ID1 = "id1";
    private static final String ID2 = "id2";
    private static final String ID3 = "id3";
    private static final String ID4 = "id4";
    private static final String ID5 = "id5";
    private static final String ID6 = "id6";

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
        editor.setModifyMode();

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
        editor.action(createEditorEvent(ID1, ID2));
        editor.action(createEditorEvent(ID3, ID4));
        editor.action(createEditorEvent(ID5, ID6));

        List<EditorEvent> actualHistory = editor.getEventHistory();
        assertEquals(3, actualHistory.size());
        assertEquals(ID1, actualHistory.get(0).getSource().getId());
        assertEquals(ID2, actualHistory.get(0).getDestination().getId());
        assertEquals(ID3, actualHistory.get(1).getSource().getId());
        assertEquals(ID4, actualHistory.get(1).getDestination().getId());
        assertEquals(ID5, actualHistory.get(2).getSource().getId());
        assertEquals(ID6, actualHistory.get(2).getDestination().getId());
    }

    private EditorEvent createEditorEvent(String id1, String id2) {
        return new EditorEvent(new EditorObject(id1), new EditorObject(id2));
    }

    @Test
    void shouldNotHaveEventInHistory() {
        editor.setSaveHistory(false);

        editor.action(createEditorEvent(ID1, ID2));

        assertTrue(editor.getEventHistory().isEmpty());
    }

}
