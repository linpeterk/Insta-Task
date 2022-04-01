package com.example.instatask.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.instatask.database.datamodel.UserEntity

@Dao
interface UserInfoDao {
    @Query("SELECT * FROM UserInfoData")
    fun getAllUserData(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM UserInfoData WHERE id = :id")
    fun getUserById(id: Int): UserEntity?

    @Insert
    suspend fun insert(item: List<UserEntity>)

    @Update
    suspend fun update(item: UserEntity)

    @Delete
    suspend fun delete(item: UserEntity)

    @Query("DELETE FROM UserInfoData")
    suspend fun deleteAllUser()
}