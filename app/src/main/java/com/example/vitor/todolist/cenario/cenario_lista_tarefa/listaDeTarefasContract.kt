package com.example.vitor.todolist.cenario.cenario_lista_tarefa

import android.content.Context
import com.example.vitor.todolist.entidades.Tarefa

interface listaDeTarefasContract {

    interface view {
        fun exibeLista(lista: MutableList<Tarefa>)
    }

    interface presenter {
        fun onAtualizaLista(context: Context)
    }
}