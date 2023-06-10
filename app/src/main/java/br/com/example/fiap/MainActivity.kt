package br.com.example.fiap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_main)

        val btn_login = findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener {
            val campoLogin = findViewById<EditText>(R.id.login_campo)
            val login = campoLogin.text.toString()
            val campoSenha = findViewById<EditText>(R.id.senha_campo)
            val senha = campoSenha.text.toString()
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)

//            if (login == "teste" && senha == "teste") {
//                val intent = Intent(this, MainPage::class.java)
//                startActivity(intent)
//            } else {
//                Toast.makeText(this, "Acesso negado!", Toast.LENGTH_SHORT).show()
//            }
        }

//        val fab = findViewById<Button>(R.id.btn_login)
//        fab.setOnClickListener{
//            val intent = Intent(this, MainPage::class.java)
//            startActivity(intent)
//        }
    }
}