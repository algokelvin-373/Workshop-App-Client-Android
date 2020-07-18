package com.algokelvin.workshop.app.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_note_details.*

class NoteDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)

        val data = intent.getParcelableExtra<Note>("data_note")

        titleNote.text = data?.title
        descriptionNote.text = data?.description
    }
}