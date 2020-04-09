package com.ghalym.databasesexample.roomExample.Note.displayNote

import com.ghalym.databasesexample.roomExample.ICommonView
import com.ghalym.databasesexample.roomExample.Note.data.Note

interface IDisplayNoteView : ICommonView {

    fun onDeletSuccess(position:Int);
    fun onDeleteAllSuccess();
    fun onFetchData(result: List<Note>);

}