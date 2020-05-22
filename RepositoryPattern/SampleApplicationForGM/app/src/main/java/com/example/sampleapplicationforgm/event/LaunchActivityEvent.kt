package com.example.sampleapplicationforgm.event

class LaunchActivityEvent(activityToLaunch: Class<*>?) : CustomEvent<Any?>(activityToLaunch)