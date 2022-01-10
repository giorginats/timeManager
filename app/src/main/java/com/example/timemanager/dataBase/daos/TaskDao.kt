package com.example.timemanager.dataBase.daos

import androidx.room.*
import com.example.timemanager.dataBase.entities.Task
import io.reactivex.Flowable

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT * FROM task")
    fun getTasks(): Flowable<List<Task>>
}