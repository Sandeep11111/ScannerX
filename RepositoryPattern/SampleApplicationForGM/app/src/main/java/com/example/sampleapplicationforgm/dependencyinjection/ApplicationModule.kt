package com.example.sampleapplicationforgm.dependencyinjection

import android.app.Application
import dagger.Module

@Module
class ApplicationModule(private val application: Application)