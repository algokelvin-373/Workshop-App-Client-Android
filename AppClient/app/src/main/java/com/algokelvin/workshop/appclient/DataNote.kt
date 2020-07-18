package com.algokelvin.workshop.appclient

data class DataNote (val data: ArrayList<Note>)

data class Note (
    val id: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val done: String? = null
)

fun dummyNote(): ArrayList<Note> {
    val data = ArrayList<Note>()
    data.add(Note(1, "Meeting 1", "Meeting with A at 5.00 PM", "false"))
    data.add(Note(2, "Meeting 2", "Meeting with B at 6.00 PM", "false"))
    data.add(Note(3, "Meeting 3", "Meeting with C at 7.00 PM", "false"))
    data.add(Note(4, "Meeting 4", "Meeting with D at 8.00 PM", "false"))
    data.add(Note(5, "Meeting 5", "Meeting with E at 9.00 PM", "false"))
    data.add(Note(6, "Meeting 6", "Meeting with F at 10.00 PM", "false"))
    data.add(Note(7, "Meeting 7", "Meeting with G at 11.00 PM", "false"))
    return data
}
