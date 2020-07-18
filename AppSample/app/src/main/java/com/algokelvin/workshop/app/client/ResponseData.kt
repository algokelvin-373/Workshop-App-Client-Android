package com.algokelvin.workshop.app.client

import android.util.Log
import androidx.lifecycle.LiveData

fun getDataNoteResponse(): LiveData<DataNote> {
    val callDataNote = ApiAppInstance.create(BuildConfig.URL_BACK_END).getDataNote()
//    return callDataNote.execute().body()?.note!!
    val data = callDataNote.execute().body()
    Log.i("data", data.toString())
}