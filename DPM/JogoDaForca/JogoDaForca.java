
import java.util.ArrayList;
import java.util.Arrays;

public class JogoDaForca {
    private String dica;
    private String[] letras_reveladas = new String[6];
    private String palavra;
    private int indice = -1;
    private int acertos =0;
    private int erros = 0;
    private int count_position;
    private int tentativas;


    public JogoDaForca() {

    }


    public void iniciar(String novaPalavra, String novaDica) {
        this.palavra = novaPalavra.toUpperCase();
        this.dica = novaDica;
        this.tentativas = novaPalavra.length() + 4; //Números de tentativas
    }


    public boolean adivinhou(String letra) {

        boolean confirm_repeticao = false;

        if (this.palavra.contains(letra.toUpperCase())) {

            for(int x = 0; x < this.letras_reveladas.length; x++) {

                if(letra.toUpperCase().equals(this.letras_reveladas[x])) {
                    System.out.println("Letra repetida!!");

                    confirm_repeticao = true;
                    this.erros += 1;
                    return false;
                }
            }
            if(confirm_repeticao == false) {
                String[] letras = this.palavra.split("");
                for(int i=0 ; i<this.palavra.length(); i++) {
                    if(letras[i].equals(letra.toUpperCase())) {

                        this.acertos =(this.acertos + 1);
                    }

                }
                this.letras_reveladas[this.count_position]  = letra.toUpperCase();
                this.count_position = (this.count_position + 1);
            }
        }else {
            this.erros += 1;
            return false;
        }
        return true;
    }

    public boolean terminou() {
        if(this.acertos == this.palavra.length() || this.erros >= tentativas ){
            return true;
        };
        return false;
    }

    public String getPalavra() {
        String[] letras_palavra = this.palavra.split("");
        Boolean confirm = true;

        for(int i = 0;i<letras_palavra.length;i++) {
            confirm = false;
            for(int x = 0; x < this.letras_reveladas.length; x++) {

                if(letras_palavra[i].equals(this.letras_reveladas[x])) {

                    confirm = true;
                    break;
                }

            }

            if(confirm == false) {
                letras_palavra[i] = "*";
            }

        }

        String resultado_final = Arrays.toString(letras_palavra);
        resultado_final = resultado_final.replace(",", " ");
        resultado_final = resultado_final.replace("[", " ");
        resultado_final = resultado_final.replace("]", " ");

        return resultado_final;

    }

    public Integer numerosTentativasRestante(){
        return this.tentativas - this.erros;
    }


    public String getDica() {
        return this.dica;
    }

    public int getAcertos() {
        return this.acertos;
    }

    public int getErros() {
        return this.erros;
    }

    public int getLetrasDistintas(){
        ArrayList list = new ArrayList<String>();
        String [] listPalavra = this.palavra.split("");
        for(int i = 0; i < this.palavra.length();i++ ){
            if(!list.contains(listPalavra[i])){
                list.add(listPalavra[i]);
            }
        }
        return list.size();
    }

    public String getResultado() {

        String result = "Você foi enforcado";

        if(this.acertos==this.palavra.length()) {
            result = "Você ganhou";
        }

        return result;
    }
}
	