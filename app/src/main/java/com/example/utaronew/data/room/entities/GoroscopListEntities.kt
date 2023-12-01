package com.example.utaronew.data.room.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize
import com.example.utaronew.data.models.ROOM.GoroscopList

@VersionedParcelize
@Entity()
data class GoroscopListEntities(
    @PrimaryKey(autoGenerate = false) val id: Long,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="image") val image: String,
    @ColumnInfo(name="desc") val desc: String
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    fun toGoroscopList(): GoroscopList = GoroscopList(
        id = id,
        name = name,
        image = image,
        desc = desc
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(desc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GoroscopListEntities> {
        override fun createFromParcel(parcel: Parcel): GoroscopListEntities {
            return GoroscopListEntities(parcel)
        }

        override fun newArray(size: Int): Array<GoroscopListEntities?> {
            return arrayOfNulls(size)
        }
    }
}