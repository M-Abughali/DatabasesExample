package com.ghalym.databasesexample.SqliteExample.Presenter

import com.ghalym.databasesexample.SqliteExample.data.Note

interface INotePresenter {

    fun onAddSuccess();
    fun onDeletSuccess();
    fun onEditSuccess();
    fun onDeleteAllSuccess();
    fun onFetchData(result: ArrayList<Note>);
    fun onError(mgs: String)

}