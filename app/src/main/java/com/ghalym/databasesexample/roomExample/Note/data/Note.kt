package com.ghalym.databasesexample.roomExample.Note.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import java.io.Serializable

@Entity(tableName = "note_table")
 data class Note(
    @PrimaryKey(autoGenerate = true)  val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String
) : Serializable{}

