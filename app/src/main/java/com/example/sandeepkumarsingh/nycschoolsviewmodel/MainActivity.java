package com.example.sandeepkumarsingh.nycschoolsviewmodel;

//https://github.com/WhosNickDoglio/NYCSchools

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sandeepkumarsingh.nycschoolsviewmodel.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import io.reactivex.disposables.CompositeDisposable;
import nycschools.shared.BaseActivity;
import nycschools.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {

    @Inject
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel.setViewCallbackEmitter(getViewCallbackEmitter());
        binding.setViewModel(mainViewModel);
    }

    @Override
    protected CompositeDisposable registerUnboundViewEvents() {
        CompositeDisposable events = new CompositeDisposable();
        return events;
    }
}
