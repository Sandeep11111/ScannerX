package com.example.dagger2codemitch.di;

import com.example.dagger2codemitch.viewmodels.ViewModelProviderFactory;

import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindfactory(ViewModelProviderFactory viewModelProviderFactory);
}
