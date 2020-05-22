package com.example.networkutil

import com.example.networkutil.RetrofitNetworkUtil.Companion.instance
import dagger.Module
import dagger.Provides

@Module
class NetworkUtilModule {
    @Provides
    fun provideGsonUtil(): GsonUtil {
        return GsonUtil.instance
    }

    @Provides
    fun provideRetrofitNetworkUtil(): RetrofitNetworkUtil {
        return instance
    }
}