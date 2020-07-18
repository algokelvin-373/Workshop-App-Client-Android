package com.algokelvin.workshop.app.client

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class DataNote(val note: ArrayList<Note>?)

@Parcelize
data class Note(
    val id: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val done: String? = null
): Parcelable

fun dummyNote(): ArrayList<Note> {
    val data = ArrayList<Note>()
    data.add(Note(1, "Kotlin", "Kotlin is fun", "false"))
    data.add(Note(2, "Java", "Java is fun", "false"))
    return data
}