package com.example.salvador_pessoas

class Pessoa {
    var id: Int
    var idade: Int
    var nome: String

    constructor(nome:String, idade: Int){
        this.id = -1
        this.nome = nome
        this.idade = idade
    }

    constructor(id: Int, nome:String, idade: Int){
        this.id = id
        this.nome = nome
        this.idade = idade
    }

    override fun toString(): String {
        return this.nome
    }
}