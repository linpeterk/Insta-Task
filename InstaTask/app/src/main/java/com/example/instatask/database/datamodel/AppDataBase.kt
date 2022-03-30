package com.example.instatask.database.datamodel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.instatask.database.dao.TaskData

@Database(entities = [Task::class], version =1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskData

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase?=null;

        fun getDatabase(context: Context):AppDatabase{

            val tempInstance = INSTANCE
            if (tempInstance!= null)
            {
                return tempInstance
            }

            synchronized(this)
            {
                var instance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "peter").build()
                INSTANCE  = instance
                return instance
            }
        }
    }
}