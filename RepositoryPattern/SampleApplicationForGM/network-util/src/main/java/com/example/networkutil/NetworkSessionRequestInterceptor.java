package com.example.networkutil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkSessionRequestInterceptor implements Interceptor {

    public NetworkSessionRequestInterceptor() {
    }

    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        builder.addHeader("Accept-Language", "en-US");
        Request request = builder.build();
        return chain.proceed(request);
    }

}

