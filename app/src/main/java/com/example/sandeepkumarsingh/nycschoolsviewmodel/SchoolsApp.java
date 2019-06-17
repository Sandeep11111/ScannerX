package com.example.sandeepkumarsingh.nycschoolsviewmodel;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import nycschools.di.AppComponent;
import nycschools.di.DaggerAppComponent;

public class SchoolsApp extends Application implements HasActivityInjector {

    protected static AppComponent component;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .application(this)
                .build();
               component.inject(this);
        //Given more time I would of initialized debugging tools here (Timber and Leak Canary)
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
