package com.example.basicandroidarchitecture.event;

public class LaunchActivityEvent extends CustomEvent {

    public LaunchActivityEvent(Class activityToLaunch) {
        super(activityToLaunch);
    }
}

