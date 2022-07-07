package filme;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import manipulacao.Manipulacao;


//a idéia é: separar em occorências únicas, contar quantas vezes ocorre cada ocorrêcia e ordena-las em ordem decrescente
public class Ranking {
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
        int[] qtd=new int[set.size()];
        for (int i = 0; i < historico.length; i++) {
            for(int j=0;j<set.size();j++){
                if (nomeFilmes[j].equals(historico[i])) qtd[j]++;
            }
        }
        
        String[] dadosArray = new String[set.size()];
        String dadosString=new String();
        //juntando os dois arrays
        for(int i=0;i<set.size();i++){
            dadosArray[i]=qtd[i] + "," + nomeFilmes[i] +";";
        }
        for(int i=0;i<set.size();i++){
            for(int j = 1 ; j < set.size() ; j++){
                if(qtd[i] < qtd[j]){
                    String tmp = dadosArray[i];
                    dadosArray[i] = dadosArray[j];
                    dadosArray[j] = tmp;
                }
                dadosString+=dadosArray[i];
            }
        }

        String[] dados = dadosString.split(";");
        System.out.println("=============== FILMES MAIS ASSISTIDOS ================");
        for(int i=0;i<set.size();i++){
            String[] dados2 = dados[i].split(",");
            System.out.println(i+1 + "." + dados2[1] + ":" + dados2[0] + "\n");
        }
        System.out.println("=======================================================");
    }
}
