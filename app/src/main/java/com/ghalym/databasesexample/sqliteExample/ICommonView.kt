package com.ghalym.databasesexample.sqliteExample

interface ICommonView {
    fun onShowLoading();
    fun onHideLoading();
    fun onError(mgs: String)

}