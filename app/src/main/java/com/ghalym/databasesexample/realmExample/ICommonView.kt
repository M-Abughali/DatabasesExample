package com.ghalym.databasesexample.realmExample

interface ICommonView {
    fun onShowLoading();
    fun onHideLoading();
    fun onError(mgs: String)

}