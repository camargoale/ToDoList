package com.example.vitor.todolist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_item_lista.view.*

class TarefaAdapter(val context: Context, val tarefas: List<String>)
    : RecyclerView.Adapter<TarefaAdapter.ViewHolder>() {

    var clickListener : ((tarefa:String, index: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, tarefas[position], clickListener)
    }

    fun setOnItemClickListener(clique: ((tarefa:String, index: Int) -> Unit)) {
        this.clickListener = clique
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, taskNome: String, clickListener: ((tarefa:String, index: Int) -> Unit)?) {
            itemView.tvtarefa.text = taskNome

            if(clickListener != null){
                itemView.setOnClickListener{
                    clickListener.invoke(taskNome, adapterPosition)
                }
            }
        }

    }
}