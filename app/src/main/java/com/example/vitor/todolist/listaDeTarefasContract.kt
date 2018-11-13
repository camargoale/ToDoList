package com.example.vitor.todolist

import android.content.Context

interface listaDeTarefasContract {

    interface view {
        fun exibeLista(lista: MutableList<Tarefa>)
    }

    interface presenter {
        fun onAtualizaLista(context: Context)
    }
}