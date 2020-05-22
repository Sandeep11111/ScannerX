package com.example.sampleapplicationforgm.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.sampleapplicationforgm.R
import com.example.sampleapplicationforgm.databinding.ActivityMainBinding
import com.example.sampleapplicationforgm.event.LaunchActivityEvent
import com.example.sampleapplicationforgm.viewmodel.MainActivityViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @JvmField
    @Inject
    var mainActivityViewModel: MainActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainActivityViewModel
        binding.lifecycleOwner = this
        lifecycle.addObserver(mainActivityViewModel!!)

        //observe launch activity event
        mainActivityViewModel!!.launchDetailActivity.observe(this, Observer { launchActivityEvent: LaunchActivityEvent ->
            if (!launchActivityEvent.isEventHasBeenHandled) {
                startActivity(Intent(this, launchActivityEvent.contentIfEventNotHandled as Class<*>))
            }
        })
    }
}