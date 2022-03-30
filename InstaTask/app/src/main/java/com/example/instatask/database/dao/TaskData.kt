package com.example.instatask.database.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.instatask.database.datamodel.Task

@Dao
interface TaskData {


//    @Query("SELECT * FROM task")
//    fun fetchAllTask(): LiveData<List<Task>>

    @Query("SELECT * FROM task")
    fun fetchAllTask(): LiveData<List<Task>>

    @Query("SELECT * FROM task where categories=:id")
    fun fetchCategory(id:Int): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task:Task)

    @Query("DELETE FROM task where taskId=:id")
    suspend fun deleteTaskById(id:Int)

    @Query("DELETE FROM task")
    suspend fun deleteTask()


}