package com.example.sampleapplicationforgm.event;

public class LaunchActivityEvent extends CustomEvent {

    public LaunchActivityEvent(Class activityToLaunch) {
        super(activityToLaunch);
    }
}
