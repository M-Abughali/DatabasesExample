package com.ghalym.databasesexample.sqliteExample.Note.displayNote

import com.ghalym.databasesexample.sqliteExample.ICommonView
import com.ghalym.databasesexample.sqliteExample.Note.data.Note

interface IDisplayNoteView : ICommonView {

    fun onDeletSuccess(position:Int);
    fun onDeleteAllSuccess();
    fun onFetchData(result: ArrayList<Note>);

}