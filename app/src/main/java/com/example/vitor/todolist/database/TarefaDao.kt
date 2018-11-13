package com.example.vitor.todolist.database

import android.arch.persistence.room.*
import com.example.vitor.todolist.entidades.Tarefa

@Dao
interface TarefaDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert (tarefa: Tarefa)

    @Query ("SELECT * FROM tarefa")
    fun getAll(): List<Tarefa>

    @Delete
    fun delete (tarefa: Tarefa)

}