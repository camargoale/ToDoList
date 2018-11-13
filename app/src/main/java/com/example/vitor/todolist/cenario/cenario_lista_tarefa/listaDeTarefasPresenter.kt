package com.example.vitor.todolist.cenario.cenario_lista_tarefa

import android.content.Context
import com.example.vitor.todolist.database.AppDatabase
import com.example.vitor.todolist.entidades.Tarefa
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