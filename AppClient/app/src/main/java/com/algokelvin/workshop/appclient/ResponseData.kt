package com.algokelvin.workshop.appclient

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun getResponseDataNote(): LiveData<DataNote> {
    val responseDataNote = MutableLiveData<DataNote>()
    val data = ApiAppInstance.create(BuildConfig.URL).getNote()
    data.enqueue(object : Callback<DataNote> {
        override fun onFailure(call: Call<DataNote>, t: Throwable) {
            responseDataNote.postValue(null)
        }
        override fun onResponse(call: Call<DataNote>, response: Response<DataNote>) {
            Log.i("NoteApp", response.code().toString())
            responseDataNote.postValue(response.body())
        }
    })
    return responseDataNote
}