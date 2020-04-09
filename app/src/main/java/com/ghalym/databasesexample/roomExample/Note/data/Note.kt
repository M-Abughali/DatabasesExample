package com.ghalym.databasesexample.roomExample.Note.data

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.io.Serializable

@RealmClass
open class Note() : RealmObject(),Parcelable {
    @PrimaryKey
    var id: Int = 0
    var title: String? = null
    var content: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        title = parcel.readString()
        content = parcel.readString()
    }

    constructor(
        title: String,
        content: String
    ) : this(){
        this.title = title;
        this.content = content
    }
    constructor(
        id: Int,
        title: String,
        content: String
    ) : this(){
        this.id = id;
        this.title = title;
        this.content = content
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }

}

