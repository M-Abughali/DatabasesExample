package com.ghalym.databasesexample.SqliteExample

interface ICommonView {
    fun onShowLoading();
    fun onHideLoading();
    fun onError(mgs: String)

}