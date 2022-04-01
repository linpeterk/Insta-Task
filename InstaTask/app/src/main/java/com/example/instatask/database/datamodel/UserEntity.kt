package com.example.instatask.database.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserInfoData")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "user_full_name")
    var user_full_name: String,

    @ColumnInfo(name = "user_email_address")
    var user_email_address: String,

    @ColumnInfo(name = "user_password")
    var user_passsword: String,

    @ColumnInfo(name = "user_address")
    var user_address: String,

    @ColumnInfo(name = "user_zip_code")
    var user_zip_code: Int
)
