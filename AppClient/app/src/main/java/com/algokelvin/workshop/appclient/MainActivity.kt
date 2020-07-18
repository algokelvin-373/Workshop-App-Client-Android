package com.algokelvin.workshop.appclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        noteViewModel.getNote().observe(this, Observer {
            rvItemNote.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = AdapterNote(it.data)
            }
        })
    }
}