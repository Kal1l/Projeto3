package filme;

import java.io.File;
import java.util.Scanner;

import client.Multa;
import manipulacao.Manipulacao;

/*
Problemas:
    Caso do cliente alugando filmes pra classificações maiores ainda não resolvido

 Lista de afazeres:
    Adicionar quando o cliente não existir
    Adicionar o IOException e o FileNotFound
    Ao devolver adicionar o preço do filme
 */

public class AlugarDevolver {
    public void alugarFilme() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("DIGITE O CODIGO DO CLIENTE");
        String codigo = in.nextLine();
        File verificaFilmeAlugado = new File(Manipulacao.filmesAlugados + codigo + ".txt");
        if(verificaFilmeAlugado.length() == 0) {
            System.out.println("ESCOLHA UM FILME DA LISTA A SEGUIR(DIGITE O CÓDIGO DO FILME) :");
            File filmes = new File(Manipulacao.filmes);
            for(File filme: filmes.listFiles()){
                String[] dados = Manipulacao.lerArquivo(filme).split(";");
                System.out.println("===============================");
                System.out.print("Codigo do filme :" + filme.getName().replace(".txt", ""));
                System.out.println("Filme : " + dados[0]);
                System.out.println("Classificação : "+dados[3]);
            }
            System.out.println("===============================");
            //File cliente = new File(Manipulacao.clientes+codigo+".txt");
            //String[] idade = Manipulacao.lerArquivo(cliente).split(",");  (Começo da exceção do cliente pegando filmes para classifiações maiores)
            String codigoFilme1 = in.nextLine();
            String codigoFilme2 = in.nextLine();
            String codigoFilme3 = in.nextLine();
            double preco = 0;
            int filmesTotal = 0;
            String aluguel = "";
            String salvaDados = "";
            for(File filme : filmes.listFiles()){
                String codigoDoFilmeProcura = filme.getName().replace(".txt","");
                String[] dados = Manipulacao.lerArquivo(filme).split(";");
                if(codigoFilme1.equals(codigoDoFilmeProcura) || codigoFilme2.equals(codigoDoFilmeProcura) ||
                    codigoFilme3.equals(codigoDoFilmeProcura)){
                        aluguel+=dados[0] + ";" + dados[4] + "\n";
                        preco += Double.parseDouble(dados[4].replaceAll(",", "."));
                        File historicoCliente=new File(Manipulacao.historicoClientes+codigo+".txt");
                        Manipulacao.escreverArquivo(historicoCliente, dados[0]+"\n");
                        File historicoFilmes=new File(Manipulacao.historicoFilmes+"historico.txt");
                        Manipulacao.escreverArquivo(historicoFilmes, dados[0]+"\n");
                        filmesTotal++;
                }
            }
            //Adiciona o valor da multa inicial
            salvaDados+= "Total : R$ ;" + preco + " ;"+filmesTotal+ "\n" + "\n" + aluguel;
            File aluguelFilme = new File(Manipulacao.filmesAlugados + codigo + ".txt");
            Manipulacao.escreverArquivoApagando(aluguelFilme, salvaDados);
            System.out.println("ALUGUEL REALIZADO");
        } else {
            System.out.println("CLIENTE POSSUI PENDENCIAS EM NOSSO SISTEMA");
        }
    }

    public void devolverFilme() throws Exception {
        Multa multa = new Multa();
        Scanner in = new Scanner(System.in);
        System.out.println("DIGITE O CODIGO DO CLIENTE");
        String codigo = in.nextLine();
        File verificaFilmeAlugado = new File(Manipulacao.filmesAlugados + codigo + ".txt");
        //quando o cliente possui algum filme e não possui multa
        if(verificaFilmeAlugado.length() != 0 && multa.verificarMulta(codigo) == true) {
            File aluguelFilme = new File(Manipulacao.filmesAlugados + codigo + ".txt");
            aluguelFilme.delete();
            System.out.println("DEVOLUCAO REALIZADA");
        }
        else{
            System.out.println("NÃO FOI POSSÍVEL REALIZAR A DEVOLUÇÃO, POIS O CLIENTE NÃO POSSUI FILMES OU POSSUI PENDENCIAS");
        }
    }
}
