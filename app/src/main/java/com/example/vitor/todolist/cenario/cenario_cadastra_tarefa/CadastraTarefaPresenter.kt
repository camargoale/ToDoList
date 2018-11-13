package com.example.vitor.todolist.cenario.cenario_cadastra_tarefa

import android.content.Context
import com.example.vitor.todolist.database.AppDatabase
import com.example.vitor.todolist.entidades.Tarefa
import com.example.vitor.todolist.database.TarefaDao
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CadastraTarefaPresenter (val view: CadastraTarefaContract.View): CadastraTarefaContract.Presenter {

    override fun onSalvaTarefa(context: Context, tarefa: Tarefa) {
        val tarefaDao: TarefaDao = AppDatabase.getInstance(context).TarefaDao()
        doAsync {
            tarefaDao.insert(tarefa)
            uiThread {
                view.salvoComSucesso()
            }
        }
    }
}