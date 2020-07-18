package com.algokelvin.workshop.app.client

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_note.view.*

class AdapterNote(private val listNote: ArrayList<Note>, private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
    }

    override fun getItemCount(): Int = listNote.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tvTitleNote.text = listNote[position].title
        holder.itemView.tvDescriptionNote.text = listNote[position].description

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "You choose ${listNote[position].title}", Toast.LENGTH_LONG).show()

            val intentToDetail = Intent(context, NoteDetails::class.java)
            val dataNote = Note(
                listNote[position].id,
                listNote[position].title,
                listNote[position].description,
                listNote[position].description
            )
            intentToDetail.putExtra("data_note", dataNote)
            context.startActivity(intentToDetail)
        }
    }

    class NoteViewHolder(view: View): RecyclerView.ViewHolder(view)
}