package br.com.ifpb.newjogodaforca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.ifpb.newjogodaforca.banco.Banco
import br.com.ifpb.newjogodaforca.jogo.Forca

class MainActivity : AppCompatActivity() {
    private lateinit var jogo: Forca
    private lateinit var banco: Banco
    private lateinit var dica: TextView
    private lateinit var letra: EditText
    private lateinit var layout: TextView
    private lateinit var letrasUsadas: TextView
    private lateinit var menssagem: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.dica = findViewById(R.id.tvDica)
        this.letra = findViewById(R.id.tvLetra)
        this.button = findViewById(R.id.button);
        this.layout = findViewById(R.id.Tvlayout)
        this.letrasUsadas = findViewById(R.id.TvLetrasUsadas)
        this.menssagem = findViewById(R.id.TvMessagem)

        this.start()

        this.button.setOnClickListener(){

            if (jogo.jogar(letra.text.toString())) {
                this.menssagem.text = "Parabens!! voce acertou a letra "
            }
            else {
                this.menssagem.text = "Voce errou a letra "
            }

            if(jogo.terminou()) {
                this.menssagem.text = jogo.menssagem
                Thread.sleep(2000)
                this.start()
            }

            this.layout.text = jogo.layout.toString()
            this.letrasUsadas.text = jogo.letrasUsadas.toString()

        }

    }

    fun start(){
        this.banco = Banco()
        val palavra = this.banco.palavra()
        val dica = this.banco.dica()

        this.jogo = Forca(palavra, dica)
        this.dica.text = this.jogo.dica
        this.layout.text = jogo.layout.toString()
        this.letrasUsadas.text = jogo.letrasUsadas.toString()
    }
}