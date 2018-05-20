package com.example07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Editor {

    private EditorMode editorMode;
    private Map<EditorMode, Consumer<EditorEvent>> actions;
    private List<EditorEvent> eventHistory;
    private boolean saveHistory;

    public Editor() {
        editorMode = EditorMode.DRAW_MODE;
        eventHistory = new ArrayList<>();
        saveHistory = true;
        actions = new HashMap<>();
        actions.put(EditorMode.DRAW_MODE, new ActionDraw());
        actions.put(EditorMode.MODIFY_MODE, new ActionModify());
        actions.put(EditorMode.ADD_MODE, new ActionAdd());
        actions.put(EditorMode.DELETE_MODE, new ActionDelete());
        actions.put(EditorMode.JOIN_MODE, new ActionJoin());
        actions.put(EditorMode.CUT_MODE, new ActionCut());
    }

    public boolean isSaveHistory() {
        return saveHistory;
    }

    public void setSaveHistory(boolean saveHistory) {
        this.saveHistory = saveHistory;
    }

    public boolean isDrawMode() {
        return editorMode.equals(EditorMode.DRAW_MODE);
    }

    public void setDrawMode() {
        editorMode = EditorMode.DRAW_MODE;
    }

    public boolean isModifyMode() {
        return editorMode.equals(EditorMode.MODIFY_MODE);
    }

    public void setModifyMode() {
        editorMode = EditorMode.MODIFY_MODE;
    }

    public boolean isAddMode() {
        return editorMode.equals(EditorMode.ADD_MODE);
    }

    public void setAddMode() {
        editorMode = EditorMode.ADD_MODE;
    }

    public boolean isDeleteMode() {
        return editorMode.equals(EditorMode.DELETE_MODE);
    }

    public void setDeleteMode() {
        editorMode = EditorMode.DELETE_MODE;
    }

    public boolean isJoinMode() {
        return editorMode.equals(EditorMode.JOIN_MODE);
    }

    public void setJoinMode() {
        editorMode = EditorMode.JOIN_MODE;
    }

    public boolean isCutMode() {
        return editorMode.equals(EditorMode.CUT_MODE);
    }

    public void setCutMode() {
        editorMode = EditorMode.CUT_MODE;
    }

    public List<EditorEvent> getEventHistory() {
        return eventHistory;
    }

    public void action(EditorEvent editorEvent) {
        if (saveHistory) {
            eventHistory.add(editorEvent);
        }

        actions.get(editorMode).accept(editorEvent);
    }

}
