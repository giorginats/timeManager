package com.example.timemanager.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.timemanager.dataBase.daos.TaskDao
import com.example.timemanager.dataBase.entities.Task

@Database(
    entities = [Task::class],
    version = 1,
    exportSchema = false
)
abstract class TMDataBase : RoomDatabase() {
    abstract val taskDao: TaskDao
}