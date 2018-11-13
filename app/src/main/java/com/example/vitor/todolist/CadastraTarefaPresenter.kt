package com.example.vitor.todolist

import android.content.Context
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CadastraTarefaPresenter (val view: CadastraTarefaContract.View): CadastraTarefaContract.Presenter{

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