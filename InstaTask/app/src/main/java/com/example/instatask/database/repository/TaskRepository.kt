package com.example.instatask.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.instatask.database.dao.TaskData
import com.example.instatask.database.datamodel.AppDatabase
import com.example.instatask.database.datamodel.Task

class TaskRepository (application: Application){


     private lateinit var taskDao: TaskData

    init{

        var database= AppDatabase.getDatabase(application)
        taskDao = database.taskDao()
    }

    val readAllTasks: LiveData<List<Task>> = taskDao.fetchAllTask()

    suspend fun deleteTaskById(id:Int)
    {
        taskDao.deleteTaskById(id)
    }
    suspend fun insertCustomer(task: Task)
    {
        taskDao.insertTask(task)
    }

    suspend fun deleteAll()
    {
        taskDao.deleteTask()
    }


}