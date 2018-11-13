package com.example.vitor.todolist

import android.content.Context
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class listaDeTarefasPresenter(val view: listaDeTarefasContract.view) : listaDeTarefasContract.presenter {

    override fun onAtualizaLista(context: Context) {
        val TarefaDao = AppDatabase.getInstance(context).TarefaDao()
        doAsync {
            val tarefasList = TarefaDao.getAll() as MutableList<Tarefa>
            uiThread {
                view.exibeLista(tarefasList)
            }
        }
    }
}