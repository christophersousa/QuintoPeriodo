package br.com.ifpb.jogodaforca
import java.util.Scanner

fun main(){
    val jogo = Forca("Bola", "Principal objeto do Futebol")

    while (!jogo.terminou()){
        print("\nDica:" + jogo.dica + "\n")
        print("Palavra: " + jogo.layout + "\n")
        print("Letras usadas: " + jogo.letrasUsadas + "\n")
        print("Tentativas restantes: " + jogo.tentativas + "\n")

        print("Digite uma Letra: ")
        val letra = Scanner(System.`in`)
        val t = letra.next()
        if (jogo.jogar(t)) {
            print("voce acertou a letra "+ t.toUpperCase() + "\n");
            print("total de acertos="+jogo.acertos + "\n");
        }
        else {
            print("Voce errou a letra "+ t + "\n");
        }


    }
}