package com.ghalym.databasesexample.roomExample

interface ICommonView {
    fun onShowLoading();
    fun onHideLoading();
    fun onError(mgs: String)

}