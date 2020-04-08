package com.ghalym.databasesexample.sqliteExample.Note.displayNote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.sqliteExample.Note.data.Note
import kotlinx.android.synthetic.main.row_note.view.*

class NoteAdapter(val data: ArrayList<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    lateinit var onShowOptionMenu:OnShowOptionMenu;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_note, parent, false);
        val holder = NoteViewHolder(view);
        return holder;
    }

    override fun getItemCount(): Int {
        return data.size;
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val item = data[position];
        holder.lblTitle.text = item.title;
        holder.lblContent.text = item.content;

    }


    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val lblTitle = itemView.lblTitle as TextView
        val lblContent = itemView.lblContent as TextView
        val imgMenu = itemView.imgMenu as ImageView
        init {
            imgMenu.setOnClickListener {
                onShowOptionMenu?.showOption(itemView,adapterPosition)
            }
        }

    }
}