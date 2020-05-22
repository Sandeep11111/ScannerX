package com.example.sampleapplicationforgm.application

import android.app.Activity
import android.app.Application
import android.app.Fragment
import com.example.sampleapplicationforgm.dependencyinjection.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

class BasicAppApplication : Application(), HasActivityInjector, HasFragmentInjector {
    @JvmField
    @Inject
    var dispatchingAndroidActivityInjector: DispatchingAndroidInjector<Activity>? = null

    @JvmField
    @Inject
    var dispatchingAndroidFragmentInjector: DispatchingAndroidInjector<Fragment>? = null
    override fun onCreate() {
        super.onCreate()
        buildDaggerComponent()
    }

    private fun buildDaggerComponent() {
        DaggerApplicationComponent
                .create()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidActivityInjector!!
    }

    override fun fragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidFragmentInjector!!
    }
}