package com.example.applicationforgm.di;

import com.example.applicationforgm.application.BasicAppApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        AndroidViewModule.class,

})
public interface ApplicationComponent {
    void inject(BasicAppApplication basicAppApplication);
}
