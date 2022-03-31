package com.example.instatask.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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



    //MutableLiveData<List<Task>>
    suspend fun deleteTaskById(id:Int)
    {
        taskDao.deleteTaskById(id)
    }
    suspend fun insertTask(task: Task)
    {
        taskDao.insertTask(task)
    }

    suspend fun deleteAll()
    {
        taskDao.deleteTask()
    }

    suspend fun fetchCategory(id:Int) : List<Task>
    {
        var  readSomeTasks: List<Task>  = taskDao.fetchCategory(id)

        return readSomeTasks
    }

    suspend fun fetchTaskById(id:Int) : Task
    {
        return taskDao.fetchTaskById(id)
    }



}