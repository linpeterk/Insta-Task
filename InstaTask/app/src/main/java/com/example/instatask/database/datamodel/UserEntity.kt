package com.example.instatask.database.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class UserRow(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    @ColumnInfo(name = "user_full_name")
    val user_full_name: String,

    @ColumnInfo(name = "user_email_address")
    val user_email_address: String,

    @ColumnInfo(name = "user_password")
    val user_passsword: String,

    @ColumnInfo(name = "user_address")
    val user_address: String,

    @ColumnInfo(name = "user_zip_code")
    val user_zip_code: String
)
