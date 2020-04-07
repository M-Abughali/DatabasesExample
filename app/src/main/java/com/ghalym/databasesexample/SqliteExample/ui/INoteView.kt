package com.ghalym.databasesexample.SqliteExample.ui

import com.ghalym.databasesexample.SqliteExample.ICommonView
import com.ghalym.databasesexample.SqliteExample.data.Note

interface INoteView : ICommonView {

    fun onAddSuccess();
    fun onDeletSuccess();
    fun onEditSuccess();
    fun onDeleteAllSuccess();
    fun onFetchData(result: ArrayList<Note>);

}