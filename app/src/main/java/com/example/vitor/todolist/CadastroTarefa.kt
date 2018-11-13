package com.example.vitor.todolist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro_tarefa.*

class CadastroTarefa : AppCompatActivity(), CadastraTarefaContract.View {

    companion object {
        const val EXTRA_NOVA_TAREFA: String = "novaTarefa"
    }

    var tarefa: Tarefa? = null

    val presenter: CadastraTarefaContract.Presenter = CadastraTarefaPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_tarefa)

        tarefa = intent.getSerializableExtra(EXTRA_NOVA_TAREFA) as Tarefa?
        if(tarefa!=null){
            carregaDados()
        }

        saveButton.setOnClickListener {
            if (tarefa == null){
                tarefa = Tarefa(inserido.text.toString())
            } else {
                tarefa?.task = inserido.text.toString()
            }
                presenter.onSalvaTarefa(this, tarefa!!)
            }
        }

    private fun carregaDados() {
        inserido.setText(tarefa?.task)
    }

    override fun salvoComSucesso(){
        Toast.makeText(this,"Tarefa salva com sucesso", Toast.LENGTH_SHORT).show()
        finish()
    }
}
