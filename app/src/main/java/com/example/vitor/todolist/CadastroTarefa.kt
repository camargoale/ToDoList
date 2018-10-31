package com.example.vitor.todolist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro_tarefa.*

class CadastroTarefa : AppCompatActivity() {

    companion object {
        const val EXTRA_NOVA_TAREFA: String = "novaTarefa"
    }

    var tarefa: Tarefa? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_tarefa)

        tarefa = intent.getSerializableExtra(EXTRA_NOVA_TAREFA) as Tarefa?
        if(tarefa!=null){
            carregaDados()
        }

        saveButton.setOnClickListener {
            val x = Intent()
            val todo = Tarefa(inserido.text.toString())
            x.putExtra(EXTRA_NOVA_TAREFA,todo)
            setResult(Activity.RESULT_OK, x)
            finish()
        }
    }

    private fun carregaDados() {
        inserido.setText(tarefa?.task)
    }

}
