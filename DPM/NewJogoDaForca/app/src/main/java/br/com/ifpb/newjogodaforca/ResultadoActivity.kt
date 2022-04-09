package br.com.ifpb.newjogodaforca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    private lateinit var textResult : TextView
    private lateinit var jogar : Button
    private lateinit var sair : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado2)
        setTitle("Jogo da Forca")

        this.textResult = findViewById(R.id.tvMensagem)
        this.jogar = findViewById(R.id.tvJogar)
        this.sair = findViewById(R.id.tvSair)

        this.textResult.text = intent.getStringExtra("result")

        jogar.setOnClickListener(){
            jogar()
        }

        sair.setOnClickListener(){
            finishAffinity()
        }
    }

    fun jogar(){
        val pageJogo = Intent(this, MainActivity::class.java)
        startActivity(pageJogo)
    }
}