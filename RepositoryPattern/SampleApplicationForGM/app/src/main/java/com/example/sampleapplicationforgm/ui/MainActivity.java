package com.example.sampleapplicationforgm.ui;

import android.content.Intent;
import android.os.Bundle;

import com.example.sampleapplicationforgm.R;
import com.example.sampleapplicationforgm.viewmodel.MainActivityViewModel;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivityViewModel(mainActivityViewModel);
        binding.setLifecycleOwner(this);
        getLifecycle().addObserver(mainActivityViewModel);

        //observe launch activity event
        mainActivityViewModel.launchDetailActivity.observe(this, launchActivityEvent -> {
            if (!launchActivityEvent.isEventHasBeenHandled()) {
                startActivity( new Intent(this, (Class)launchActivityEvent.getContentIfEventNotHandled()));
            }
        });

    }

}
