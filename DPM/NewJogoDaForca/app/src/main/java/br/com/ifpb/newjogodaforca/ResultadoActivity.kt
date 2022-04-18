package br.com.ifpb.newjogodaforca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    private lateinit var imgResult : ImageView
    private lateinit var jogar : Button
    private lateinit var sair : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_resultado2)

        this.imgResult = findViewById(R.id.imgResult)
        this.jogar = findViewById(R.id.tvJogar)
        this.sair = findViewById(R.id.tvSair)

        var result = intent.getBooleanExtra("result", false)

        if (result){
            imgResult.setImageResource(R.drawable.win)
        }else{
            imgResult.setImageResource(R.drawable.loser)
        }

        jogar.setOnClickListener(){
            jogar()
        }

        sair.setOnClickListener(){
            login()
        }
    }

    fun jogar(){
        val pageJogo = Intent(this, MainActivity::class.java)
        startActivity(pageJogo)
    }

    fun login(){
        val pageLogin = Intent(this, loginActivity::class.java)
        startActivity(pageLogin)
    }
}