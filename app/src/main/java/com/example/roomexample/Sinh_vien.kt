package com.example.roomexample

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Parcelize
@Entity (tableName = "SV")
data class Sinh_vien (
    @PrimaryKey val mssv: String,
    @ColumnInfo(name = "name") val Name: String?,
    @ColumnInfo(name = "birth_day") val Birth: String?,
    @ColumnInfo(name =  "home_town") val Home: String?,
    @ColumnInfo(name = "email") val Email:String?
):Parcelable



