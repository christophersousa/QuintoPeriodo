package br.com.ifpb.newjogodaforca.bancoDeImagens

import br.com.ifpb.newjogodaforca.R

class bancoImagens {
    var imagensIds = intArrayOf(
        R.drawable.completo,
        R.drawable.perna,
        R.drawable.mao_esquerda,
        R.drawable.mao_direita,
        R.drawable.corpo,
        R.drawable.cabeca,
        R.drawable.inicio
    )

    public fun carregarImg (tentativas: Int): Int{
        return imagensIds[tentativas];
    };
}