package com.ghalym.databasesexample.SqliteExample.Note.addNote

import com.ghalym.databasesexample.SqliteExample.ICommonView

interface IUpdateNoteView : ICommonView {
    fun onUpdateSuccess();
}