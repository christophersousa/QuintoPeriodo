package br.com.ifpb.newjogodaforca

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.ifpb.newjogodaforca.banco.Banco
import br.com.ifpb.newjogodaforca.bancoDeImagens.bancoImagens
import br.com.ifpb.newjogodaforca.jogo.Forca


class MainActivity : AppCompatActivity() {
    private lateinit var jogo: Forca
    private lateinit var banco: Banco
    private lateinit var dica: TextView
    private lateinit var letra: EditText
    private lateinit var layout: TextView
    private lateinit var button: Button
    private lateinit var img: ImageView
    private lateinit var bancoImagens: bancoImagens
    private lateinit var letrasUsadas: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Jogo da Forca")

        this.bancoImagens = bancoImagens()

        this.dica = findViewById(R.id.tvDica)
        this.letra = findViewById(R.id.tvLetra)
        this.letrasUsadas = findViewById(R.id.letrasUsadas)
        this.button = findViewById(R.id.button);
        this.layout = findViewById(R.id.Tvlayout)
        this.img = findViewById(R.id.imageView)

        this.start()

        this.button.setOnClickListener(){
            if(letra.text.length == 1) {
                if (jogo.jogar(letra.text.first().toString())) {
                    Toast.makeText(this@MainActivity, "Parabens!! voce acertou a letra ", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@MainActivity, "Voce errou a letra ", Toast.LENGTH_LONG).show()
                }

                this.img.setImageResource(this.bancoImagens.carregarImg(jogo.tentativas));

                if (jogo.terminou(letra.text.toString())) {
                    this.img.setImageResource(this.bancoImagens.carregarImg(jogo.tentativas));
                    Thread.sleep(2000)
                    this.result(jogo.menssagem )
                }

                this.layout.text = jogo.getLetrasUsadas()
                this.letrasUsadas.text = jogo.letrasUsadas.toString()
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
        this.layout.text = jogo.getLetrasUsadas()
        this.letrasUsadas.text = jogo.letrasUsadas.toString()
        this.img.setImageResource(this.bancoImagens.carregarImg(jogo.tentativas));

    }

    fun result(result: Boolean){
        val pageResult = Intent(this, ResultadoActivity::class.java)
        pageResult.putExtra("result",result)
        startActivity(pageResult)
    }
}