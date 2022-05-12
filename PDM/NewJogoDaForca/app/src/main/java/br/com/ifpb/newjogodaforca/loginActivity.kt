package br.com.ifpb.newjogodaforca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import br.com.ifpb.newjogodaforca.jogo.Forca

class loginActivity : AppCompatActivity() {

    private lateinit var iniciar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        this.iniciar = findViewById(R.id.btIniciar)
        this.iniciar.setOnClickListener{
            jogar()
        }
    }
    fun jogar(){
        val pageJogo = Intent(this, MainActivity::class.java)
        startActivity(pageJogo)
    }
}