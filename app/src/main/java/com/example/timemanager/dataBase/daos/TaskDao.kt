package com.example.timemanager.dataBase.daos

import androidx.room.*
import com.example.timemanager.dataBase.entities.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM task")
    fun getTasks(): Flow<List<Task>>
}