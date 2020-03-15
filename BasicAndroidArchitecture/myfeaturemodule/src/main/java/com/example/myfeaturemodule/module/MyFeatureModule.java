package com.example.myfeaturemodule.module;

import com.example.myfeaturemodule.service.MyFeatureService;
import com.example.networkutilmodule.GsonUtil;
import com.example.networkutilmodule.NetworkSessionRequestInterceptor;
import com.example.networkutilmodule.RetrofitNetworkUtil;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyFeatureModule {

    @Provides
    @Singleton
    MyFeatureService provideMyFeatureService(GsonUtil gsonUtil, RetrofitNetworkUtil retrofitNetworkUtil) {
        Gson gson = gsonUtil.buildGson().create();
        String baseUrl = "http://dummy.restapiexample.com/api/";
        int writeTimeoutInSec = 60;
        int readTimeoutInSec = 60;
        return retrofitNetworkUtil.buildRestHttpAdapter(baseUrl, writeTimeoutInSec, readTimeoutInSec, gson)
                .addInterceptor( new NetworkSessionRequestInterceptor())
                .build()
                .create(MyFeatureService.class);

    }
}
