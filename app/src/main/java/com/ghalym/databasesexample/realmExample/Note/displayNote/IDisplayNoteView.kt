package com.ghalym.databasesexample.realmExample.Note.displayNote

import com.ghalym.databasesexample.realmExample.ICommonView
import com.ghalym.databasesexample.realmExample.Note.data.Note

interface IDisplayNoteView : ICommonView {

    fun onDeletSuccess(position:Int);
    fun onDeleteAllSuccess();
    fun onFetchData(result: ArrayList<Note>);

}