package com.example.vitor.todolist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_lista_de_tarefas.*
import java.util.ArrayList

class listaDeTarefas : AppCompatActivity() {

    companion object {
        private const val REQUEST_CADASTRO: Int = 1
        private const val LISTA: String = "ListaTarefas"
    }

    private var tarefasList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_tarefas)

        btnAddTarefa.setOnClickListener(){
            val cadastrarTarefa = Intent(this,CadastroTarefa::class.java)
            startActivityForResult(cadastrarTarefa, REQUEST_CADASTRO)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CADASTRO && resultCode == Activity.RESULT_OK){
            val novaTarefa: String? = data?.getStringExtra(CadastroTarefa.EXTRA_NOVA_TAREFA)
            if (novaTarefa != null) {
                tarefasList.add(novaTarefa)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        carregaLista()

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putStringArrayList(LISTA, tarefasList as ArrayList<String>?)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        if(savedInstanceState != null)
            tarefasList = savedInstanceState.getStringArrayList(LISTA).toMutableList()
    }

    fun carregaLista() {
        val adapter = TarefaAdapter(tarefasList)
        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, layoutManager.orientation)

        rvTarefa.adapter = adapter
        rvTarefa.layoutManager = layoutManager
        rvTarefa.addItemDecoration(dividerItemDecoration)
    }

}
