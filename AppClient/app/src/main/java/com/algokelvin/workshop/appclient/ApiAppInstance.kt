package com.algokelvin.workshop.appclient

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import java.util.concurrent.TimeUnit

interface ApiAppInstance {

    @Headers("Content-type: application/json")
    @GET("/api/todos")
    fun getNote(): Call<DataNote>

    companion object {
        fun create(link: String): ApiAppInstance {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient().newBuilder()

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(3, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build()

            val retrofit = Retrofit.Builder()
                .client(okHttpClient.build())
                .baseUrl(link)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiAppInstance::class.java)
        }
    }
}