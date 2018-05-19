package com.example07;

import java.util.ArrayList;
import java.util.List;

public class Editor {

    private boolean drawMode;
    private boolean modifyMode;
    private boolean addMode;
    private boolean deleteMode;
    private boolean joinMode;
    private boolean cutMode;

    private List<EditorEvent> eventHistory;

    public Editor() {
        drawMode = true;
        eventHistory = new ArrayList<>();
    }

    public boolean isDrawMode() {
        return drawMode;
    }

    public void setDrawMode() {
        drawMode = true;
        modifyMode = false;
        addMode = false;
        deleteMode = false;
        joinMode = false;
        cutMode = false;
    }

    public boolean isModifyMode() {
        return modifyMode;
    }

    public void setModificationMode() {
        drawMode = false;
        modifyMode = true;
        addMode = false;
        deleteMode = false;
        joinMode = false;
        cutMode = false;
    }

    public boolean isAddMode() {
        return addMode;
    }

    public void setAddMode() {
        drawMode = false;
        modifyMode = false;
        addMode = true;
        deleteMode = false;
        joinMode = false;
        cutMode = false;
    }

    public boolean isDeleteMode() {
        return deleteMode;
    }

    public void setDeleteMode() {
        drawMode = false;
        modifyMode = false;
        addMode = false;
        deleteMode = true;
        joinMode = false;
        cutMode = false;
    }

    public boolean isJoinMode() {
        return joinMode;
    }

    public void setJoinMode() {
        drawMode = false;
        modifyMode = false;
        addMode = false;
        deleteMode = false;
        joinMode = true;
        cutMode = false;
    }

    public boolean isCutMode() {
        return cutMode;
    }

    public void setCutMode() {
        drawMode = false;
        modifyMode = false;
        addMode = false;
        deleteMode = false;
        joinMode = false;
        cutMode = true;
    }

    public List<EditorEvent> getEventHistory() {
        return eventHistory;
    }

    public void action(EditorEvent editorEvent) {
        eventHistory.add(editorEvent);
        if (drawMode) {
            actionDraw(editorEvent);
        } else if (modifyMode) {
            actionModify(editorEvent);
        } else if (addMode) {
            actionAdd(editorEvent);
        } else if (deleteMode) {
            actionDelete(editorEvent);
        } else if (joinMode) {
            actionJoin(editorEvent);
        } else if (cutMode) {
            actionCut(editorEvent);
        }
    }

    private void actionCut(EditorEvent editorEvent) {
        //perform cut action on objects from event
    }

    private void actionJoin(EditorEvent editorEvent) {
        //perform join action on objects from event
    }

    private void actionDelete(EditorEvent editorEvent) {
        //perform delete action on objects from event
    }

    private void actionAdd(EditorEvent editorEvent) {
        //perform add action on objects from event
    }

    private void actionModify(EditorEvent editorEvent) {
        //perform modify action on objects from event
    }

    private void actionDraw(EditorEvent editorEvent) {
        //perform draw action on objects from event
    }
}
