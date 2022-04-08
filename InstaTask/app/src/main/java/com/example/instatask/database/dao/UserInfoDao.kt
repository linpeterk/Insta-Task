package com.example.instatask.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.instatask.database.datamodel.UserRow

@Dao
interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(newUser: UserRow)

   @Query("SELECT * FROM Users")
    fun getAllUserData():LiveData<List<UserRow>>

    @Query("SELECT * FROM Users WHERE id = :id")
    fun getUserById(id: Int): UserRow

    @Update
    suspend fun updateUser(item: UserRow)

    @Delete
    suspend fun deleteUser(item: UserRow)

   // @Query("DELETE FROM UserList")
   //suspend fun deleteAllUser()
}