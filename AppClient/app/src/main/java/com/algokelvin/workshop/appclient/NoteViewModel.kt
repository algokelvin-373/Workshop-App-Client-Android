package com.algokelvin.workshop.appclient

import androidx.lifecycle.ViewModel

class NoteViewModel(): ViewModel() {
    fun getNote() = getResponseDataNote()
}