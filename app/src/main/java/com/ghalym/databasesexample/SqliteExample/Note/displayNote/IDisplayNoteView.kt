package com.ghalym.databasesexample.SqliteExample.Note.displayNote

import com.ghalym.databasesexample.SqliteExample.ICommonView
import com.ghalym.databasesexample.SqliteExample.Note.data.Note

interface IDisplayNoteView : ICommonView {

    fun onDeletSuccess(position:Int);
    fun onDeleteAllSuccess();
    fun onFetchData(result: ArrayList<Note>);

}