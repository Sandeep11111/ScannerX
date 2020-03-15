package com.example.dagger2codemitch.di;

import com.example.dagger2codemitch.di.auth.AuthViewModelsModule;
import com.example.dagger2codemitch.ui.AuthActivity;
import com.example.dagger2codemitch.ui.AuthViewModel;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

//    @Provides
//    static String someString(){
//        return "this is a test string";
//    }
}
