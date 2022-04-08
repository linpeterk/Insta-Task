package com.example.instatask.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.instatask.database.dao.UserInfoDao
import com.example.instatask.database.datamodel.AppDatabase
import com.example.instatask.database.datamodel.UserRow


class UserRepository(private val userInfoDao: UserInfoDao) {
    val readAllData: LiveData<List<UserRow>> = userInfoDao.getAllUserData()

    suspend fun addUser(newUser: UserRow){
        userInfoDao.insertUser(newUser)
    }
    suspend fun update(item: UserRow){
        //userInfoDao.update(item)
    }
    suspend fun deleteUser(item: UserRow){
        //userInfoDao.delete(item)
    }

    suspend fun deleteAllUsers(){
       // userInfoDao.deleteAllUser()
    }
}