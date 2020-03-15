package com.example.basicandroidarchitecture.di;

import com.example.basicandroidarchitecture.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AndroidViewModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
