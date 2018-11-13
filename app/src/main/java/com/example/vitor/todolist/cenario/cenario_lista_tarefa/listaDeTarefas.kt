package com.example.vitor.todolist.cenario.cenario_lista_tarefa

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.vitor.todolist.R
import com.example.vitor.todolist.entidades.Tarefa
import com.example.vitor.todolist.cenario.cenario_cadastra_tarefa.CadastroTarefa
import kotlinx.android.synthetic.main.activity_lista_de_tarefas.*
import java.util.ArrayList

class listaDeTarefas : AppCompatActivity(), listaDeTarefasContract.view {

    companion object {
        private const val REQUEST_CADASTRO: Int = 1
        private const val LISTA: String = "ListaTarefas"
    }

    private var tarefasList: MutableList<Tarefa> = mutableListOf()

    val presenter: listaDeTarefasContract.presenter = listaDeTarefasPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_tarefas)

        btnAddTarefa.setOnClickListener() {
            val cadastrarTarefa = Intent(this, CadastroTarefa::class.java)
            startActivity(cadastrarTarefa)
        }

    }

    override fun onResume() {
        super.onResume()
        presenter.onAtualizaLista(this)

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putStringArrayList(LISTA, tarefasList as ArrayList<String>?)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState != null)
            tarefasList = savedInstanceState.getSerializable(LISTA) as MutableList<Tarefa>
    }

    override fun exibeLista(lista: MutableList<Tarefa>) {

        tarefasList = lista

        val adapter = TarefaAdapter(this, tarefasList)

        adapter.setOnItemClickListener { tarefa, indexTarefaClicada ->
            val editaTarefa = Intent(this, CadastroTarefa::class.java)
            editaTarefa.putExtra(CadastroTarefa.EXTRA_NOVA_TAREFA, tarefa)
            startActivity(editaTarefa)
        }

        val layoutManager = LinearLayoutManager(this)

        rvTarefa.adapter = adapter
        rvTarefa.layoutManager = layoutManager
    }
}
