package com.example.networkutilmodule;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNetworkUtil {

    public static RetrofitNetworkUtil getInstance() {
        return new RetrofitNetworkUtil();
    }

    public RetrofitNetworkUtil() {}

    public RetrofitBuilder buildRestHttpAdapter(String baseUrl, long writeTimeoutInSeconds, long readTimeoutInSeconds, Gson gson) {
        return new RetrofitBuilder(new OkHttpClient())
                .baseUrl(baseUrl)
                .writeTimeoutInSeconds(writeTimeoutInSeconds)
                .readTimeoutInSeconds(readTimeoutInSeconds)
                .addConverter(GsonConverterFactory.create(gson));
    }

    public class RetrofitBuilder {
        private OkHttpClient okHttpClient;
        private List<Interceptor> interceptors = new ArrayList<>();
        private List<Converter.Factory> converters = new ArrayList<>();
        private long writeTimeoutInSeconds;
        private long readTimeoutInSeconds;
        private String baseUrl;

        public RetrofitBuilder(OkHttpClient httpClient) {
            okHttpClient = httpClient;
        }

        public RetrofitBuilder addInterceptor(Interceptor interceptor) {
            if (interceptors != null) {
                interceptors.add(interceptor);
            }
            return this;
        }

        public RetrofitBuilder addConverter(Converter.Factory converter) {
            if(converters != null) {
                converters.add(converter);
            }
            return this;
        }

        public RetrofitBuilder writeTimeoutInSeconds(long timeoutInSeconds) {
            writeTimeoutInSeconds = timeoutInSeconds;
            return this;
        }

        public RetrofitBuilder readTimeoutInSeconds(long timeoutInSeconds) {
            readTimeoutInSeconds = timeoutInSeconds;
            return this;
        }

        public RetrofitBuilder baseUrl(String url) {
            baseUrl = url;
            return this;
        }

        public Retrofit build() {

            final OkHttpClient.Builder okHttpClientBuilder = okHttpClient.newBuilder();

            okHttpClientBuilder.writeTimeout(writeTimeoutInSeconds, TimeUnit.SECONDS);
            okHttpClientBuilder.readTimeout(readTimeoutInSeconds, TimeUnit.SECONDS);

            for(Interceptor interceptor : interceptors) {
                okHttpClientBuilder.addInterceptor(interceptor);
            }

            // Http Log interceptor
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            okHttpClientBuilder.networkInterceptors().add(httpLoggingInterceptor);


            final Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
            retrofitBuilder.client(okHttpClientBuilder.build());

            for(Converter.Factory converter : converters) {
                retrofitBuilder.addConverterFactory(converter);
            }

            retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            retrofitBuilder.baseUrl(baseUrl);

            return retrofitBuilder.build();
        }
    }
}
