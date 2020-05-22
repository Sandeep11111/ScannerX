package com.example.myfeature

import com.example.networkutil.GsonUtil
import com.example.networkutil.NetworkSessionRequestInterceptor
import com.example.networkutil.RetrofitNetworkUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MyFeatureModule {
    @Provides
    @Singleton
    fun provideMyFeatureService(gsonUtil: GsonUtil, retrofitNetworkUtil: RetrofitNetworkUtil): MyFeatureService {
        val gson = gsonUtil.buildGson().create()
        val baseUrl = "http://dummy.restapiexample.com/api/"
        val writeTimeoutInSec = 60
        val readTimeoutInSec = 60
        return retrofitNetworkUtil.buildRestHttpAdapter(baseUrl, writeTimeoutInSec.toLong(), readTimeoutInSec.toLong(), gson)
                .addInterceptor(NetworkSessionRequestInterceptor())
                .build()
                .create(MyFeatureService::class.java)
    }
}