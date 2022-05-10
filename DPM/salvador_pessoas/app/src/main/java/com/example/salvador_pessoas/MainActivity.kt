package com.example.salvador_pessoas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var nome: EditText
    private lateinit var idade: EditText
    private lateinit var btSalvar: Button
    private lateinit var btListar: Button
    private lateinit var db: pessoaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.db = pessoaDAO(this)

        this.nome = findViewById(R.id.etFormName)
        this.idade = findViewById(R.id.etFormIdade)

        this.btSalvar = findViewById(R.id.etBtSalvar)
        this.btListar = findViewById(R.id.etBtListar)

        this.btSalvar.setOnClickListener{salvar()}
        this.btListar.setOnClickListener{listar()}

    }

    fun salvar(){
        val nome = this.nome.text.toString()
        val idade = this.idade.text.toString().toInt()
        val pessoa = Pessoa(nome, idade)
        this.db.insert(pessoa)
        Toast.makeText(this,"Pessoa ${pessoa.nome} salva", Toast.LENGTH_LONG).show()
    }
    fun listar(){
        Log.i("APP_SALVADOR",this.db.select().toString())
    }
}