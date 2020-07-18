package com.algokelvin.workshop.app.client

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface ApiAppInstance {

    //TODO: Post Data ( Create )
    @POST("api/todos")
    fun postDataNote(): Call<DataNote>

    //TODO: Get Data ( Read )
    @Headers("Content-Type: application/json")
    @GET("api/todos")
    fun getDataNote(): Call<DataNote>

    //TODO: Patch Data ( Upload )
    @PATCH("")
    fun doneDataNote(): Call<DataNote>

    //TODO: Delete Data ( Delete )
    @DELETE("")
    fun deleteDataNote(): Call<DataNote>

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