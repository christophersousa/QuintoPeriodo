package br.com.ifpb.newjogodaforca.jogo

class Forca (var palavra: String, var dica: String) {
    val letrasUsadas = linkedSetOf<String>()
    var tentativas: Int
    var acertos: Int
    val layout = arrayListOf<String>()
    var menssagem = true

    init {

        this.tentativas = 6
        this.acertos = 0
        this.palavra.forEach { it
            this.layout.add("*")
        }

    }


    fun jogar(letra: String): Boolean{
        // verificar se o jogo está ativo
        // informar que o jogo já encerrou
        if(this.terminou(letra)){
            return false;
        }

        // verificar se a letra é "nova", ou seja, não informada anteriormente
        // registrar a letra no banco de letras jogadas
        if(!verificarLetra(letra.uppercase())){
            return false;
        }
        // verificar se faz parte da palavra secreta
        // atualizar o layout
        // registrar pontuação

        if(this.palavra.uppercase().contains(letra.uppercase())){
            atualizaLayout(letra)
        }else{
            // else
            // registrar o erro
            this.tentativas = this.tentativas - 1;

            return false;
        }
        return true
    }

    private fun verificarLetra(letra: String): Boolean{

        if(letra.length > 1){
            print("Você precisa digitar um caracter!!\n")
            this.tentativas = this.tentativas - 1;
            return false
        }else if(this.letrasUsadas.contains(letra)){
            // informar que a tentativa não é válida
            print("Letra já escolhida!\n")
            return false;
        }
        this.letrasUsadas.add(letra.uppercase())
        return true;
    }

    fun terminou(letra: String):Boolean {
        if(letra.uppercase() == this.palavra.uppercase()){
            return true
        }else if(this.palavra == null){
            this.menssagem = false
            return true;
        } else if(this.acertos == this.palavra.length){
            this.menssagem = true
            return true;
        }else if(this.tentativas == 0){
            this.menssagem =false
            return true;
        };
        return false;
    }

    private fun atualizaLayout(letra: String){
        this.palavra.forEachIndexed { index, c ->
            if(c.toString().uppercase() == letra.uppercase()){
                this.acertos =  this.acertos + 1
                this.layout.set(index, c.toString())
            }
        }

    }

    public fun getLetrasUsadas():String{
        var palavraSecreta = "";
        this.layout.forEach {it
            palavraSecreta +=  it;
        }
        System.out.println(palavraSecreta)
        return palavraSecreta
    }

}