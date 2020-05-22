package com.example.sampleapplicationforgm.dependencyinjection;

import com.example.sampleapplicationforgm.ui.DetailActivity;
import com.example.sampleapplicationforgm.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AndroidViewModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract DetailActivity bindDetailActivity();
}
