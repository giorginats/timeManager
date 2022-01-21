package com.example.timemanager.dataBase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
    @PrimaryKey
    val id : Int? = null,
    val taskName: String,
    val description : String?,
    val isDone : Boolean = true
)
