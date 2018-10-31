package com.example.vitor.todolist

import android.arch.persistence.room.*

@Dao
interface TarefaDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert (tarefa: Tarefa)

    @Query ("SELECT * FROM tarefa")
    fun getAll(): List<Tarefa>

    @Delete
    fun delete (tarefa: Tarefa)

}