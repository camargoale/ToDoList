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

        saveButton.setOnClickListener {
            val x = Intent()
            x.putExtra(EXTRA_NOVA_TAREFA,inserido.text.toString())
            setResult(Activity.RESULT_OK, x)
            finish()
        }
    }

}
