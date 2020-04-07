package com.ghalym.databasesexample.SqliteExample.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.P)
class DbConnection(context: Context?, name: String?, version: Int, openParams: SQLiteDatabase.OpenParams) :
    SQLiteOpenHelper(context, name, version, openParams) {

    val TABLE_NOTE_NAME = "Note";
    val TABLE_NOTE_COLUMN_ID_NAME = "id";
    val TABLE_NOTE_COLUMN_TITLE_NAME = "title";
    val TABLE_NOTE_COLUMN_CONTENT_NAME = "content";


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TABLE_NOTE_NAME ($TABLE_NOTE_COLUMN_ID_NAME integer primary key autoincrement ,$TABLE_NOTE_COLUMN_TITLE_NAME text,$TABLE_NOTE_COLUMN_CONTENT_NAME text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("drop table IF exists $TABLE_NOTE_NAME")
        onCreate(db)
    }

    var db: SQLiteDatabase? = null;

    fun openDb() {
        db = writableDatabase
    }

    fun closeDb() {
        db?.close();
    }

    fun insertNoteToDb(note: Note): Long? {
        var contentValues = ContentValues();
        contentValues.put("$TABLE_NOTE_COLUMN_TITLE_NAME", note.title);
        contentValues.put("$TABLE_NOTE_COLUMN_CONTENT_NAME", note.content);

        openDb()
        val result = db?.insert("$TABLE_NOTE_NAME", null, contentValues);
        closeDb()

        return result;
    }

    fun removeNoteFromDb(note: Note): Boolean {
        val arg = arrayOf(note.id.toString());
        openDb()
        val result = db?.delete("$TABLE_NOTE_NAME", "$TABLE_NOTE_COLUMN_ID_NAME =? ", arg);
        closeDb()

        if (result != 0) {
            return true;
        }

        return false;
    }

    fun getAllNote(): ArrayList<Note> {
        val allNotes = ArrayList<Note>()
        openDb()
        val curser = db?.rawQuery("select * from $TABLE_NOTE_NAME", null);
        closeDb()

        while (curser!!.moveToNext()) {

            val id = curser.getInt(curser.getColumnIndex("$TABLE_NOTE_COLUMN_ID_NAME"));
            val title = curser.getString(curser.getColumnIndex("$TABLE_NOTE_COLUMN_TITLE_NAME"));
            val content = curser.getString(curser.getColumnIndex("$TABLE_NOTE_COLUMN_CONTENT_NAME"));

            val note = Note(id, title, content);
            allNotes.add(note);
        }

        return allNotes;

    }

    fun deleteAllNotes(): Boolean {
        openDb()
        val result = db?.delete("$TABLE_NOTE_NAME", null, null);
        closeDb()
        if (result != 0) {
            return true;
        }

        return false;
    }

    fun deleteNotes(note: Note): Boolean {

        var contentValues = ContentValues();
        contentValues.put("$TABLE_NOTE_COLUMN_TITLE_NAME", note.title);
        contentValues.put("$TABLE_NOTE_COLUMN_CONTENT_NAME", note.content);

        val arg = arrayOf(note.id.toString());

        openDb()
        val result = db?.update("$TABLE_NOTE_NAME", contentValues, "$TABLE_NOTE_COLUMN_ID_NAME =? ", arg);
        closeDb()
        if (result != 0) {
            return true;
        }

        return false;
    }


}