package br.com.ifpb.newjogodaforca.banco

class Banco {
    val palavras: LinkedHashMap<String, String>
    lateinit var sorteada: String

    init{
        this.palavras = linkedMapOf()
        this.montarPalavras()
        this.sorteio()
    }

    private  fun montarPalavras(){
        this.palavras.put("Bola", "Principal objeto usado em um jogo de Futebol")
        this.palavras.put("Casa", "Local onde as pessoas residem")
        this.palavras.put("Programador", "Pessoa que códifica sistemas e sites")
        this.palavras.put("Gato", "Animal de extimação independente")
        this.palavras.put("Jornal", "Objeto de papel que contém informação")
        this.palavras.put("Passaro", "Animal emplumado")
    }

    private fun sorteio(){
        this.sorteada = this.palavras.keys.random()
    }

    fun palavra(): String{
        return this.sorteada
    }

    fun dica(): String{
        return this.palavras.getValue(this.sorteada)
    }

}