package com.example.vitor.todolist

import android.content.Context

interface CadastraTarefaContract {

    interface View {
        fun salvoComSucesso()
    }

    interface Presenter {
        fun onSalvaTarefa(context: Context, tarefa: Tarefa)
    }
}