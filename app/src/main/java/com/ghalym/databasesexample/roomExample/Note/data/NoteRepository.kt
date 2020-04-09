package com.ghalym.databasesexample.roomExample.Note.data

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.deleteFromRealm

class NoteRepository(context: Context) {

    val realm: Realm;

    init {
        Realm.init(context);
        val config = RealmConfiguration.Builder().name("realmD").build();
        Realm.setDefaultConfiguration(config)
        realm = Realm.getDefaultInstance();

    }


    fun insertNoteToDb(note: Note) {
      //  realm.beginTransaction();
        realm.executeTransaction {
            val size = realm.where(Note::class.java).findAll().size;
            note.id = size;
            realm.insertOrUpdate(note);
        }

    }

    fun removeNoteFromDb(note: Note) {
        realm.beginTransaction();
        realm.where(Note::class.java).equalTo("id", note.id).findFirst()?.deleteFromRealm();
        realm.commitTransaction();
    }

    fun getAllNote(): ArrayList<Note> {
        val allNotes = ArrayList<Note>()
        realm.beginTransaction();
        val all = realm.where(Note::class.java).findAll();
        all.forEach { one -> allNotes.add(one); }
        realm.commitTransaction();
        return allNotes;

    }

    fun deleteAllNotes(): Boolean {
        realm.beginTransaction();
        val result = realm.where(Note::class.java).findAll().deleteAllFromRealm();
        realm.commitTransaction();
        return result;
    }

    fun updateNote(note: Note) {
        realm.beginTransaction();
        realm.insertOrUpdate(note);
        realm.commitTransaction();
    }


}