package filme;

import java.io.File;
import java.util.Scanner;

import manipulacao.Manipulacao;

public class AlugarDevolver {
    public void alugarFilme() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o codigo do cliente");
        String codigo = in.nextLine();
        File verificaFilmeAlugado = new File(Manipulacao.filmesAlugados + codigo + ".txt");
        if(verificaFilmeAlugado.length() == 0) {
            System.out.println("Escolha um filme da lista a seguir :");
            File filmes = new File(Manipulacao.filmes);
            for(File filme: filmes.listFiles()){
                String[] dados = Manipulacao.lerArquivo(filme).split(",");
                System.out.println("===============================");
                System.out.print("Codigo do filme :" + filme.getName().replace(".txt", ""));
                System.out.println("Filme : " + dados[0]);
            }
            System.out.println("===============================");
            String codigoFilme1 = in.nextLine();
            String codigoFilme2 = in.nextLine();
            String codigoFilme3 = in.nextLine();
            String aluguel = "";
            for(File filme : filmes.listFiles()){
                String codigoDoFilmeProcura = filme.getName().replace(".txt","");
                String[] dados = Manipulacao.lerArquivo(filme).split(",");
                if(codigoFilme1.equals(codigoDoFilmeProcura) || codigoFilme2.equals(codigoDoFilmeProcura) ||
                    codigoFilme3.equals(codigoDoFilmeProcura)){
                        aluguel+=dados[0] + "," + dados[4] + "\n";
                }
            }
            File aluguelFilme = new File(Manipulacao.filmesAlugados + codigo + ".txt");
            Manipulacao.escreverArquivoApagando(aluguelFilme, aluguel);
            System.out.println("Aluguel realizado");
        } else {
            System.out.println("Cliente possui pendencias no nosso sistema");
        }
    }
}
