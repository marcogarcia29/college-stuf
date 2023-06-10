package br.com.example.fiap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_main_page)

        val fab = findViewById<Button>(R.id.btn_projeto)
        fab.setOnClickListener{
            val intent = Intent(this, listaProjetosActivity::class.java)
            startActivity(intent)
        }
    }
}