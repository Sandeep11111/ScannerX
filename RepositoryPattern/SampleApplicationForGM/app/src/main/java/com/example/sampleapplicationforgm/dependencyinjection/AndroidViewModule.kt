package com.example.sampleapplicationforgm.dependencyinjection

import com.example.sampleapplicationforgm.ui.DetailActivity
import com.example.sampleapplicationforgm.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidViewModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity?

    @ContributesAndroidInjector
    abstract fun bindDetailActivity(): DetailActivity?
}