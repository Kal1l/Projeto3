package filme;

import manipulacao.Manipulacao;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Sugerir {
    public void sugestao(){
        System.out.println("DIGITE O CADASTRO DO CLIENTE:");
        Scanner in = new Scanner(System.in);
        String codigo = in.nextLine();
        File biblioteca= new File(Manipulacao.filmes);
        File file = new File(Manipulacao.historicoClientes + codigo + ".txt");
        String[] string = Manipulacao.lerArquivo(file).split("\n");
        int i = string.length-1;
        String[] string2= string[i].split(";");
        String nomeFilme = string2[0];
        String generoFilme = string2[1];
        String atoresFilme = string2[2];
        for(File sugestao:biblioteca.listFiles()){
            String[] dados= Manipulacao.lerArquivo(sugestao) 
        }

        /*for(verificar os filmes bla bla){
            if(encontrar o genero do ultimo filme){
                salava generofilme
            }
            if(encontrar o ator do ultimo filme){
                salva atorFilme
            }
        }
        outro for que procura os que tem igual e é isso*/


    }
}
