package com.example.applicationforgm.application;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;

import com.example.applicationforgm.di.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasFragmentInjector;

public class BasicAppApplication extends Application implements HasActivityInjector, HasFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidActivityInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidFragmentInjector;

    @Override
    public void onCreate(){
        super.onCreate();
        buildDaggerComponent();
    }

    private void buildDaggerComponent() {
        DaggerApplicationComponent
                .create()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidActivityInjector;
    }

    @Override
    public AndroidInjector<android.app.Fragment> fragmentInjector() {
        return dispatchingAndroidFragmentInjector;
    }
}
