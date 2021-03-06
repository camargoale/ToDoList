package com.example.vitor.todolist

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class Tarefa(var task: String,
                  @PrimaryKey (autoGenerate = true)
                  var id: Int = 0) : Serializable