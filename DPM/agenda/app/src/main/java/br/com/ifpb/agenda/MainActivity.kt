package br.com.ifpb.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var lvPessoas: ListView
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var db: PessoaDAO
    private lateinit var lista: ArrayList<Pessoa>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.db = PessoaDAO(this)
        this.lista = db.select()
        Log.i("PESSOAS1_APP", this.lista.toString())

        this.lvPessoas = findViewById(R.id.lvMainPessoas)
        this.fabAdd = findViewById(R.id.fabMainAdd)

        this.lvPessoas.adapter = ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1, this.lista)

        val formResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            // executar quando vier a resposta
            if (it.resultCode == RESULT_OK){
                Log.i("PESSOAS2_APP", "teste")
                val nome = it.data?.getStringExtra("nome")
                val idade = it.data?.getStringExtra("idade")
                val pessoa = Pessoa(nome.toString(), idade.toString().toInt())
                Log.i("PESSOAS2_APP", pessoa.toString())
                this.db.insert(pessoa)
                (this.lvPessoas.adapter as ArrayAdapter<Pessoa>).add(pessoa)
            }
        }

        this.fabAdd.setOnClickListener{
            val intent = Intent(this, FormActivity::class.java)
            formResult.launch(intent)
        }

    }
}