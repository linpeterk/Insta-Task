package com.example.instatask.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.instatask.database.datamodel.AppDatabase
import com.example.instatask.database.datamodel.UserRow
import com.example.instatask.network.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserInfoViewModel(application: Application): AndroidViewModel(application) {

     val getAllData: LiveData<List<UserRow>>
    private val userRepository: UserRepository
    init {
        val userInfoDao = AppDatabase.getDatabase(application).UserInfoDao()
            //val userInfoDao = User.
        userRepository = UserRepository(userInfoDao)
        getAllData = userRepository.getAllUsers
    }

    fun insertNewUser(newUser: UserRow){
        viewModelScope.launch(Dispatchers.IO){
            userRepository.insert(newUser)
        }
    }

    fun getAllUsers():LiveData<List<UserRow>>{
        return userRepository.getAllUsers
    }
}