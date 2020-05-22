package com.example.sampleapplicationforgm.event;

public class CustomEvent<T>{

    private boolean eventHasBeenHandled = false;
    private T content;

    public CustomEvent(T content) {
        this.content = content;
    }

    public boolean isEventHasBeenHandled() {
        return eventHasBeenHandled;
    }

    public T getContentIfEventNotHandled() {
        if (eventHasBeenHandled) {
            return null;
        } else {
            eventHasBeenHandled = true;
            return content;
        }
    }
}
