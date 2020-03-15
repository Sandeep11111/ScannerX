package com.example.applicationforgm.di;

import com.example.applicationforgm.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AndroidViewModule {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
