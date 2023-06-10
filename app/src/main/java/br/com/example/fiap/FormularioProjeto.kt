package br.com.example.fiap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.ContactsContract.Data
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.File

class FormularioProjeto : AppCompatActivity(R.layout.activity_formulario_projeto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();

        val btnSalvar = findViewById<Button>(R.id.botao_salvar)
        val db = OtherDatabaseManager(this)
        btnSalvar.setOnClickListener {
            val campoTitulo = findViewById<EditText>(R.id.titulo)
            val titulo = campoTitulo.text.toString()
            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val descricao = campoDescricao.text.toString()

            val projetoNovo = Projeto(
                titulo = titulo,
                descricao = descricao)

            val context = applicationContext
            db.insereProjeto(titulo, descricao)

            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()

            val dao = ProjetosDao()
            dao.add(projetoNovo)
            Log.i("AdicionaProduto", "onCreate: ${dao.buscaTodos()}")
            finish()
        }

    }
}