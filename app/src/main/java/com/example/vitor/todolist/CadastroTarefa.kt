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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_tarefa)

        val tarefa: Tarefa? = intent.getSerializableExtra(EXTRA_NOVA_TAREFA) as Tarefa?
        if(tarefa!=null){
            carregaDados(tarefa)
        }

        saveButton.setOnClickListener {
            val x = Intent()
            x.putExtra(EXTRA_NOVA_TAREFA,inserido.text.toString())
            setResult(Activity.RESULT_OK, x)
            finish()
        }
    }

    private fun carregaDados(tarefa: Tarefa) {
        inserido.setText(tarefa.task)
    }

}
