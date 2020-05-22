package com.example.sampleapplicationforgm.viewmodel;

import javax.inject.Inject;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class DetailActivityViewModel extends ViewModel implements LifecycleObserver {

    @Inject
    public DetailActivityViewModel() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        System.out.println("DetailActivityViewModel onCreate called ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        System.out.println("DetailActivityViewModel onResume called ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        System.out.println("DetailActivityViewModel onStart called ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        System.out.println("DetailActivityViewModel onStop called ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        System.out.println("DetailActivityViewModel onPause called ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        System.out.println("DetailActivityViewModel onDestroy called ");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
