package com.example.sampleapplicationforgm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sampleapplicationforgm.R
import com.example.sampleapplicationforgm.databinding.ActivityDetailBinding
import com.example.sampleapplicationforgm.viewmodel.DetailActivityViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {
    @JvmField
    @Inject
    var detailActivityViewModel: DetailActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.detailActivityViewModel = detailActivityViewModel
    }
}