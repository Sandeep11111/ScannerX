package com.example.dagger2codemitch.ui;

import android.os.Bundle;
import android.util.Log;

import com.example.dagger2codemitch.R;
import com.example.dagger2codemitch.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";

    private AuthViewModel viewModel;

    @Inject
    String any_test_string;

    @Inject
    boolean isAppNull;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        viewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel.class);

        Log.d(TAG,"onCreate: "+any_test_string);
        Log.d(TAG,"onCreate is app null: "+isAppNull);
    }
}
