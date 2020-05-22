package com.example.networkutil

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

class RetrofitNetworkUtil {
    fun buildRestHttpAdapter(baseUrl: String?, writeTimeoutInSeconds: Long, readTimeoutInSeconds: Long, gson: Gson?): RetrofitBuilder {
        return RetrofitBuilder(OkHttpClient())
                .baseUrl(baseUrl)
                .writeTimeoutInSeconds(writeTimeoutInSeconds)
                .readTimeoutInSeconds(readTimeoutInSeconds)
                .addConverter(GsonConverterFactory.create(gson))
    }

    inner class RetrofitBuilder(private val okHttpClient: OkHttpClient) {
        private val interceptors: MutableList<Interceptor>? = ArrayList()
        private val converters: MutableList<Converter.Factory>? = ArrayList()
        private var writeTimeoutInSeconds: Long = 0
        private var readTimeoutInSeconds: Long = 0
        private var baseUrl: String? = null
        fun addInterceptor(interceptor: Interceptor): RetrofitBuilder {
            interceptors?.add(interceptor)
            return this
        }

        fun addConverter(converter: Converter.Factory): RetrofitBuilder {
            converters?.add(converter)
            return this
        }

        fun writeTimeoutInSeconds(timeoutInSeconds: Long): RetrofitBuilder {
            writeTimeoutInSeconds = timeoutInSeconds
            return this
        }

        fun readTimeoutInSeconds(timeoutInSeconds: Long): RetrofitBuilder {
            readTimeoutInSeconds = timeoutInSeconds
            return this
        }

        fun baseUrl(url: String?): RetrofitBuilder {
            baseUrl = url
            return this
        }

        fun build(): Retrofit {
            val okHttpClientBuilder = okHttpClient.newBuilder()
            okHttpClientBuilder.writeTimeout(writeTimeoutInSeconds, TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(readTimeoutInSeconds, TimeUnit.SECONDS)
            for (interceptor in interceptors!!) {
                okHttpClientBuilder.addInterceptor(interceptor)
            }

            // Http Log interceptor
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.networkInterceptors().add(httpLoggingInterceptor)
            val retrofitBuilder = Retrofit.Builder()
            retrofitBuilder.client(okHttpClientBuilder.build())
            for (converter in converters!!) {
                retrofitBuilder.addConverterFactory(converter)
            }
            retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            retrofitBuilder.baseUrl(baseUrl)
            return retrofitBuilder.build()
        }

    }

    companion object {
        @JvmStatic
        val instance: RetrofitNetworkUtil
            get() = RetrofitNetworkUtil()
    }
}