package com.algokelvin.workshop.app.client

data class DataNote(val note: ArrayList<Note>)
data class Note(val id: Int, val title: String, val description: String, val done: String)

fun dummyNote(): ArrayList<Note> {
    val data = ArrayList<Note>()
    data.add(Note(1, "Kotlin", "Kotlin is fun", "false"))
    data.add(Note(2, "Java", "Java is fun", "false"))
    return data
}