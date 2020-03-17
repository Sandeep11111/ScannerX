package com.example.basicandroidarchitecture.ui;

import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.basicandroidarchitecture.R;
import com.example.basicandroidarchitecture.viewmodel.MainActivityViewModel;
import com.example.myfeaturemodule.models.DummyResponse;
import com.example.myfeaturemodule.service.MyFeatureService;

import java.util.List;

import javax.inject.Inject;

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
