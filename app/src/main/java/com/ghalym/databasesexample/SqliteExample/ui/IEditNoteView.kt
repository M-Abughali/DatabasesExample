package com.ghalym.databasesexample.SqliteExample.ui

import com.ghalym.databasesexample.SqliteExample.ICommonView
import com.ghalym.databasesexample.SqliteExample.data.Note

interface IEditNoteView : ICommonView {

    fun onAddSuccess();
    fun onEditSuccess();

}