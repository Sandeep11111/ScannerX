package com.example.basicandroidarchitecture.ui;

import android.os.Bundle;

import com.example.basicandroidarchitecture.R;
import com.example.basicandroidarchitecture.databinding.ActivityDetailBinding;
import com.example.basicandroidarchitecture.viewmodel.DetailActivityViewModel;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import dagger.android.AndroidInjection;

public class DetailActivity extends AppCompatActivity {

    @Inject
    DetailActivityViewModel detailActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setDetailActivityViewModel(detailActivityViewModel);
    }
}
