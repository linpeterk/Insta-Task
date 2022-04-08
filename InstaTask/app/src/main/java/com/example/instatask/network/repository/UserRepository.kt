package com.example.instatask.network.repository

import androidx.lifecycle.LiveData
import com.example.instatask.database.dao.UserInfoDao
import com.example.instatask.database.datamodel.UserRow

class UserRepository (private val userInfoDao: UserInfoDao){

    val getAllUsers: LiveData<List<UserRow>> = userInfoDao.getAllUserData()

    suspend fun insert(newUser: UserRow){
        userInfoDao.insertUser(newUser)
    }
}