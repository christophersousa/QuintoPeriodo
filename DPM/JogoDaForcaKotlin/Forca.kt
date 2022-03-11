package br.com.ifpb.jogodaforca

class Forca (var palavra: String, var dica: String) {
    val letrasUsadas = linkedSetOf<String>()
    var tentativas: Int
    var acertos: Int
    val layout = arrayListOf<String>()

    init {
        this.tentativas = 4
        this.acertos = 0

        var i = 1
        while (i <= this.palavra.length){
            this.layout.add("*")
            i++
        }
    }

    fun jogar(letra: String): Boolean{
        // verificar se o jogo está ativo
        // informar que o jogo já encerrou
        if(terminou()){
            return false;
        }

        if(letra.length > 1){
            print("Você precisa digitar um caracter!!\n")
            this.tentativas = this.tentativas - 1;
            return false
        }

        // verificar se a letra é "nova", ou seja, não informada anteriormente
        // registrar a letra no banco de letras jogadas
        if(!verificarLetra(letra.toUpperCase())){
            return false;
        }
        // verificar se faz parte da palavra secreta
        // atualizar o layout
        // registrar pontuação

        if(this.palavra.toUpperCase().contains(letra.toUpperCase())){
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

        if(this.letrasUsadas.contains(letra)){
            // informar que a tentativa não é válida
            print("Letra já escolhida!")
            return false;
        }
        this.letrasUsadas.add(letra.toUpperCase())
        return true;
    }

    fun terminou():Boolean {
        if(this.acertos == this.palavra.length){
            print("Parabéns você ganhou!!")
            return true;
        }else if(this.tentativas == 0){
            print("Fim de Jogo, você alcançou o limite de tentativas!!")
            return true;
        };
        return false;
    }

    private fun atualizaLayout(letra: String){
        if(!this.layout.contains(letra.toUpperCase())) {
            var indice = -1

            for(i in this.palavra.split("")){
                if(i.toUpperCase() == letra.toUpperCase()){
                    this.acertos =  this.acertos + 1
                    this.layout.set(indice, i)
                }
                indice += 1
            }

        }

    }

}