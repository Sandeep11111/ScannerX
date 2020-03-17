package com.example.basicandroidarchitecture.event;

import android.app.Activity;

public class LaunchActivityEvent extends CustomEvent {

    public LaunchActivityEvent(Class activityToLaunch) {
        super(activityToLaunch);
    }
}
