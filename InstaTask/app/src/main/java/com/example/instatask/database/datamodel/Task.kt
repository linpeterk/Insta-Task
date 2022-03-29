package com.example.instatask.database.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task (

    @PrimaryKey(autoGenerate = true)
    val taskId:Int = 0,

    @ColumnInfo(name = "categories")
    val categories:Int = 0,

    @ColumnInfo(name = "task_name")
    val task_name:String? = null,

    @ColumnInfo(name = "person_name")
    val person_name:String? = null,

    @ColumnInfo(name = "description")
    val description:String? = null,

    @ColumnInfo(name = "hourly_rate")
    val hourly_rate:Int = 0,

    @ColumnInfo(name = "imageId")
    val imageId:String? = null,

    @ColumnInfo(name = "address")
    val address:String? = null

)