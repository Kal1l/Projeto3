package filme;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import manipulacao.Manipulacao;


//a idéia é: separar em occorências únicas, contar quantas vezes ocorre cada ocorrêcia e ordena-las em ordem decrescente
public class Relatório {
    public void rankearFilmes(){
        File file=new File(Manipulacao.historicoFilmes+"historico.txt");
        //historico com todos os filmes alugados
        String[] historico=Manipulacao.lerArquivo(file).split("\n");

        //Separando em única ocorrencia de palavras repetidas
        Set<String> set = new HashSet<>();
        for(String filme: historico) {
            set.add(filme);
        }
        String[] filmes = set.toArray(new String[set.size()]);
        int cont = 0;
        String[] nomeFilmes = new String[set.size()];
        for (String nomes : filmes) {
            //Array de Strings com única ocorrência
            nomeFilmes[cont++] = nomes;
        }

        //contando elementos repetidos no histórico
        int[] qtd=new int[nomeFilmes.length];
        for (int i = 0; i < historico.length; i++) {
            for(int j=0;j<qtd.length;j++){
                if (nomeFilmes[j].equals(historico[i])) qtd[j]++;
            }
        }
        
        String[] dadosArray = new String[nomeFilmes.length];
        String dadosString=new String();
        //juntando os dois arrays
        for(int i=0;i<dadosArray.length;i++){
            dadosArray[i]=qtd[i] + "," + nomeFilmes[i] +";";
        }
        for(int i=0;i<nomeFilmes.length;i++){
            for(int j = 1 ; j < dadosArray.length ; j++){
                if(qtd[i] < qtd[j]){
                    String tmp = dadosArray[i];
                    dadosArray[i] = dadosArray[j];
                    dadosArray[j] = tmp;
                }
            }
            dadosString+=dadosArray[i];
        }

        String[] dados = dadosString.split(";");
        System.out.println("=============== FILMES MAIS ASSISTIDOS ================");
        for(int i=0;i<set.size();i++){
            String[] dados2 = dados[i].split(",");
            System.out.println(i+1 + "." + dados2[1] + ":" + dados2[0] + "\n");
        }
        System.out.println("=======================================================");
    }

    public void mostrarFilmesAlugados() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("DIGITE O CADASTRO DO CLIENTE: ");
        String codigo=in.nextLine();
        File filmeAlugado = new File(Manipulacao.filmesAlugados + codigo + ".txt");
        if(filmeAlugado.length() != 0) {
            String[] dados = Manipulacao.lerArquivo(filmeAlugado).split("\n");
            String[] dados2 = dados[0].split(";");
            System.out.println("===============================");
            System.out.println(dados2[0].replace(";",":")+dados2[1]+"\n"+ "Alugou em: "+dados2[3]);
            for(int i=2;i<dados.length;i+=2){
                System.out.println(dados[i]);
            }
            System.out.println();
            System.out.println("===============================");
        }
        if(filmeAlugado.isFile()){}
        else{System.out.println("NÚMERO DE CADASTRO NÃO EXISTE");}
    }
}
