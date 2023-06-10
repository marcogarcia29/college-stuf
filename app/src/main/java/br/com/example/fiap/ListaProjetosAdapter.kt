package br.com.example.fiap

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaProjetosAdapter (
    private val context: Context,
    private val projetos: List<Projeto>
) : RecyclerView.Adapter<ListaProjetosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(projeto: Projeto) {
            val titulo = itemView.findViewById<TextView>(R.id.titulo)
            titulo.text = projeto.titulo
            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            descricao.text = projeto.descricao
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.projeto_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = projetos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val projeto = projetos[position]
        holder.vincula(projeto)
    }
}