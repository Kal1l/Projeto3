package filme;

import manipulacao.Manipulacao;
import java.io.File;
import java.util.Scanner;

public class Sugerir {
    public void sugestao(){
        System.out.println("DIGITE O CADASTRO DO CLIENTE:");
        Scanner in = new Scanner(System.in);
        String codigo = in.nextLine();
        File file = new File(Manipulacao.historicoClientes + codigo + ".txt");
        String[] string = Manipulacao.lerArquivo(file).split("\n");
        int end = string.length-1;
        String[] string2= string[end].split(";");
        String generoFilme = string2[1];
        String atoresFilme = string2[2];
        File biblioteca= new File(Manipulacao.filmes);
        for(File sugestao:biblioteca.listFiles()){
            String[] dados= Manipulacao.lerArquivo(sugestao).split(";");
            for(int i=0;i<dados.length;i++){
                if(dados[i].contains(generoFilme)){
                    System.out.println("===============================");
                    System.out.println("Titulo : " +dados[0]+ ",atores :" +dados[1]+",genero :"+dados[2]+",classificação :"+dados[3]+",preço :" + dados[4]);
                }
                else if(dados[i].contains(atoresFilme)){
                    System.out.println("===============================");
                    System.out.println("Titulo : " +dados[0]+ ",atores :" +dados[1]+",genero :"+dados[2]+",classificação :"+dados[3]+",preço :" + dados[4]);
                }
            }
        }
        System.out.println("===============================");
    }
}
