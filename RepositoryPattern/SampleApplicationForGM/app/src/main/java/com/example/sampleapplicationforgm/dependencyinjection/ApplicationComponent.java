package com.example.sampleapplicationforgm.dependencyinjection;

import com.example.sampleapplicationforgm.application.BasicAppApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        AndroidViewModule.class}
)
public interface ApplicationComponent extends AndroidInjector<BasicAppApplication> {

    void inject(BasicAppApplication basicAppApplication);

}
