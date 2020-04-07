package com.ghalym.databasesexample.SqliteExample.ui

import com.ghalym.databasesexample.SqliteExample.ICommonView
import com.ghalym.databasesexample.SqliteExample.Note.data.Note

interface INoteView : ICommonView {

    fun onDeletSuccess();
    fun onDeleteAllSuccess();
    fun onFetchData(result: ArrayList<Note>);

}