package com.example.sampleapplicationforgm.dependencyinjection

import com.example.myfeature.MyFeatureModule
import com.example.networkutil.NetworkUtilModule
import com.example.sampleapplicationforgm.application.BasicAppApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
                      ApplicationModule::class,
                      AndroidViewModule::class,
                      MyFeatureModule::class,
                      NetworkUtilModule::class])
interface ApplicationComponent : AndroidInjector<BasicAppApplication?> {
    override fun inject(basicAppApplication: BasicAppApplication?)
}