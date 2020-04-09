package com.ghalym.databasesexample.roomExample.Note.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class),version = 1,exportSchema = false)
abstract class NoteDatabase: RoomDatabase(){
    abstract fun noteDao():NoteDao
//
//    companion object{
//
//    }

}
