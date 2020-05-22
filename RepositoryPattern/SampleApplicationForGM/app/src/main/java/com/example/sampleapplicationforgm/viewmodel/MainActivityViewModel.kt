package com.example.sampleapplicationforgm.viewmodel

import androidx.lifecycle.*
import com.example.myfeature.MyFeatureService
import com.example.myfeature.models.DummyResponse
import com.example.sampleapplicationforgm.event.LaunchActivityEvent
import com.example.sampleapplicationforgm.ui.DetailActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val myFeatureService: MyFeatureService) : ViewModel(), LifecycleObserver {
    @JvmField
    var shouldShowDescription = MutableLiveData<Boolean>()
    var launchDetailActivity = MutableLiveData<LaunchActivityEvent>()
    fun doApiCall() {
        shouldShowDescription.value = true
        val disposable = myFeatureService.dummyRestResponse
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response: List<DummyResponse> ->
                    println("***Success Response: ")
                    updateResponse(response)
                }, { throwable: Throwable -> println("***Error: " + throwable.message) }) { println("On Complete") }
    }

    private fun updateResponse(response: List<DummyResponse>) {
        for (dummyResponse in response) {
            println("***Employee ID:  " + dummyResponse.id)
            println("***Employee Name:  " + dummyResponse.name)
            println("***Employee Salary:  " + dummyResponse.salary)
        }
        shouldShowDescription.value = false
    }

    fun launchDetailScreen() {
        launchDetailActivity.value = LaunchActivityEvent(DetailActivity::class.java)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        println("MainActivityViewModel onCreate called ")
        shouldShowDescription.value = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        println("MainActivityViewModel onResume called ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        println("MainActivityViewModel onStart called ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        println("MainActivityViewModel onStop called ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        println("MainActivityViewModel onPause called ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        println("MainActivityViewModel onDestroy called ")
    }

    override fun onCleared() {
        super.onCleared()
    }

}