package com.algokelvin.workshop.app.client

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }

    class NoteViewHolder(view: View): RecyclerView.ViewHolder(view)
}