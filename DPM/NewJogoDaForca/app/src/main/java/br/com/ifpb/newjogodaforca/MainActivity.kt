package br.com.ifpb.newjogodaforca

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.ifpb.newjogodaforca.banco.Banco
import br.com.ifpb.newjogodaforca.jogo.Forca


class MainActivity : AppCompatActivity() {
    private lateinit var jogo: Forca
    private lateinit var banco: Banco
    private lateinit var dica: TextView
    private lateinit var letra: EditText
    private lateinit var layout: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.dica = findViewById(R.id.tvDica)
        this.letra = findViewById(R.id.tvLetra)
        this.button = findViewById(R.id.button);
        this.layout = findViewById(R.id.Tvlayout)

        this.start()

        this.button.setOnClickListener(){
            if(letra.text.length == 1) {
                if (jogo.jogar(letra.text.first().toString())) {
                    Toast.makeText(this@MainActivity, "Parabens!! voce acertou a letra ", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@MainActivity, "Voce errou a letra ", Toast.LENGTH_LONG).show()
                }

                if (jogo.terminou(letra.text.toString())) {
                    Thread.sleep(2000)
                    this.start()
                }

                this.layout.text = jogo.layout.toString()
            }else{
                Toast.makeText(this@MainActivity, "Digite uma unica letra por vez!", Toast.LENGTH_LONG).show()
            }
        }

    }

    fun start(){
        this.banco = Banco()
        val palavra = this.banco.palavra()
        val dica = this.banco.dica()

        this.jogo = Forca(palavra, dica)
        this.dica.text = this.jogo.dica
        this.layout.text = jogo.layout.toString()
    }
}