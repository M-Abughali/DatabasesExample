package com.ghalym.databasesexample.realmExample.Note.data

import java.io.Serializable

data class Note(var id: Int = 0, var title: String, var content: String) : Serializable