package filme;

import java.io.File;
import java.util.Scanner;

import manipulacao.Manipulacao;
public class Filme {
    private String codigoFilme;
    private String titulo;
    private String atores;
    private String genero;
    private int classificacao;
    private double preco;

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
        dados += titulo + "," + atores + "," + genero + "," + classificacao + "," + preco;
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
        String[] dados = Manipulacao.lerArquivo(file).split(",");
        System.out.println("Titulo : " +dados[0]+ ",atores :" +dados[1]+",genero :"+dados[2]+",classificação :"+dados[3]+",preço :" + dados[4]);
    }

    public void listarFilmes(){
        File filme = new File(Manipulacao.filmes);
        for(File filmes : filme.listFiles()){
            String[] dados = Manipulacao.lerArquivo(filmes).split(",");
            System.out.println("====================================");
            System.out.println("Titulo : " +dados[0]+ ",atores :" +dados[1]+",genero :"+dados[2]+",classificação :"+dados[3]+",preço :" + dados[4]);
        }
        System.out.println("====================================");
    }

    public String getCodigoFilme() {
        return codigoFilme;
    }

    public void setCodigoFilme(String codigoFilme) {
        this.codigoFilme = codigoFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}