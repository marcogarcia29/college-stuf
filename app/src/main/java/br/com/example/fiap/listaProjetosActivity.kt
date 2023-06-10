package br.com.example.fiap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import br.com.example.fiap.Projeto
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class listaProjetosActivity : AppCompatActivity(R.layout.activity_lista_projetos) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();

    }

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_lista_projetos)
        val dao = ProjetosDao()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProjetosAdapter(context = this, projetos = dao.buscaTodos())
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener{
            val intent = Intent(this, FormularioProjeto::class.java)
            startActivity(intent)
        }
    }
}