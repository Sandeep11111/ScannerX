package com.example.networkutilmodule;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkUtilModule {

    @Provides
    GsonUtil provideGsonUtil() {
        return GsonUtil.getInstance();
    }

    @Provides
    RetrofitNetworkUtil provideRetrofitNetworkUtil() {
        return RetrofitNetworkUtil.getInstance();
    }
}
