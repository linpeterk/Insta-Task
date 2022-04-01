package com.example.instatask.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.instatask.database.dao.TaskData
import com.example.instatask.database.dao.UserInfoDao
import com.example.instatask.database.datamodel.AppDatabase
import com.example.instatask.database.datamodel.Task
import com.example.instatask.database.datamodel.UserEntity


class UserRepository(application: Application) {
    private lateinit var userInfoDao: UserInfoDao

    init{

        var database= AppDatabase.getDatabase(application)
        userInfoDao = database.UserInfoDao()
    }

    //Read all users
    val readAllUser: LiveData<List<UserEntity>> = userInfoDao.getAllUserData()

    suspend fun addUser(item: List<UserEntity>){
        userInfoDao.insert(item)
    }
    suspend fun update(item: UserEntity){
        userInfoDao.update(item)
    }
    suspend fun deleteUser(item: UserEntity){
        userInfoDao.delete(item)
    }

    suspend fun deleteAllUsers(){
        userInfoDao.deleteAllUser()
    }
}