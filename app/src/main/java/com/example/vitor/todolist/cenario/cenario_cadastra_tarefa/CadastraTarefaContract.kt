package com.example.vitor.todolist.cenario.cenario_cadastra_tarefa

import android.content.Context
import com.example.vitor.todolist.entidades.Tarefa

interface CadastraTarefaContract {

    interface View {
        fun salvoComSucesso()
    }

    interface Presenter {
        fun onSalvaTarefa(context: Context, tarefa: Tarefa)
    }
}