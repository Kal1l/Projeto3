package filme;

import java.io.File;
import java.util.Scanner;

/*
Fazer o método de ranking dos filmes mais alugados
 */

import manipulacao.Manipulacao;
public class Filme {
    /*private String codigoFilme;
    private String titulo;
    private String atores;
    private String genero;
    private int classificacao;
    private double preco;*/

    public void adicionarFilme(){
        Scanner in = new Scanner(System.in);
        String dados = "";
        System.out.println("Digite o codigo do filme :");
        String codigo = in.nextLine();
        System.out.println("Digite o titulo :");
        String titulo = in.nextLine();
        System.out.println("Digite os atores :");
        String atores = in.nextLine();
        System.out.println("Digite o genero :");
        String genero = in.nextLine();
        System.out.println("Digite a classificação do filme :");
        String classificacao = in.nextLine();
        System.out.println("Digite o preço do filme : ");
        String preco = in.nextLine();
        dados += titulo + ";" + atores + ";" + genero + ";" + classificacao + ";" + preco;
        File file = new File(Manipulacao.filmes + codigo + ".txt");
        Manipulacao.escreverArquivo(file, dados);
    }

    public void deletarFilme(){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o codigo de cadastro do Filme : ");
        String codigo = in.nextLine();
        File file = new File(Manipulacao.filmes + codigo + ".txt");
        file.delete();
        System.out.println("Filme removido");
    }

    public void pesquisarFilme(){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o codigo do filme : ");
        String codigo = in.nextLine();
        File file = new File(Manipulacao.filmes + codigo + ".txt");
        String[] dados = Manipulacao.lerArquivo(file).split(";");
        System.out.println("Titulo : " +dados[0]+ ",atores :" +dados[1]+",genero :"+dados[2]+",classificação :"+dados[3]+",preço :" + dados[4]);
    }

    public void listarFilmes(){
        File filme = new File(Manipulacao.filmes);
        for(File filmes : filme.listFiles()){
            String[] dados = Manipulacao.lerArquivo(filmes).split(";");
            System.out.println("====================================");
            System.out.println("Titulo : " +dados[0]+ ",atores :" +dados[1]+",genero :"+dados[2]+",classificação :"+dados[3]+",preço :" + dados[4]);
        }
        System.out.println("====================================");
    }

    public void alterarDados() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o codigo do filme : ");
        String codigo = in.nextLine();
        File filme = new File(Manipulacao.filmes + codigo + ".txt");
        String[] dados = Manipulacao.lerArquivo(filme).split(";");
        System.out.println("Digite o titulo :");
        String novoTitulo = in.nextLine();
        if(novoTitulo.equals(" ")){
            novoTitulo = dados[0];
        }
        System.out.println("Digite os atores :");
        String novosAtores = in.nextLine();
        if(novosAtores.equals(" ")){
            novosAtores = dados[1];
        }
        System.out.println("Digite o genero :");
        String novoGenero = in.nextLine();
        if(novoGenero.equals(" ")){
            novoGenero = dados[2];
        }
        System.out.println("Digite a nova classificação :");
        String novaClassificacao = in.nextLine();
        if(novaClassificacao.equals(" ")){
            novaClassificacao = dados[3];
        }
        System.out.println("Digite o novo preço :");
        String novoPreco = in.nextLine();
        if(novoPreco.equals(" ")){
            novoPreco = dados[4];
        }
        String salvaDados = novoTitulo + ';' + novosAtores + ';' + novoGenero + ';' + novaClassificacao + ';' + novoPreco;
        Manipulacao.escreverArquivoApagando(filme, salvaDados);
    }
}