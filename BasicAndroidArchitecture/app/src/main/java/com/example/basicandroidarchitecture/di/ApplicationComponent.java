package com.example.basicandroidarchitecture.di;

import com.example.basicandroidarchitecture.application.BasicAppApplication;
import com.example.myfeaturemodule.module.MyFeatureModule;
import com.example.networkutilmodule.NetworkUtilModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        AndroidViewModule.class,
        MyFeatureModule.class,
        NetworkUtilModule.class
})
public interface ApplicationComponent {

    void inject(BasicAppApplication basicAppApplication);
}
