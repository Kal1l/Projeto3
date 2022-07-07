package manipulacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Manipulacao {
    public static final String clientes = "Diretorio/clientes/cadastro/";
    public static final String filmes = "Diretorio/filmes/";
    public static final String filmesAlugados = "Diretorio/filmesAlugados/";
    public static final String historicoFilmes = "Diretorio/historico/filmes/";
    public static final String historicoClientes = "Diretorio/historico/cliente/";


    public static void escreverArquivo(File file, String texto){
        try(FileWriter fw = new FileWriter(file , true)){
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
            fw.close();
        } catch(IOException e){
            System.out.println("ERRO AO SALVAR");
        }
    }

    public static void escreverArquivoApagando(File file, String texto){
        try{
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
            fw.close();
        } catch(IOException e){
            System.out.println("ERRO AO SALVAR");
        }
    }

    public static void gerarPastas() throws IOException{
        ArrayList<File> diretorios = new ArrayList<File>();
        //talvez os paths não estejam funcionando(provalmente estão)
        diretorios.add(new File(clientes));
        diretorios.add(new File(filmes));
        diretorios.add(new File(filmesAlugados));
        diretorios.add(new File(historicoFilmes));
        diretorios.add(new File(historicoClientes));

        for(File diretorio : diretorios){
            if(!diretorio.exists()){
                diretorio.mkdirs();
            }
        }
        //caso o outro path dê errado
        File file = new File(historicoFilmes,"historico.txt");
        file.createNewFile();
    }

    public static String lerArquivo(File file){
        String aux = "";
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br =  new BufferedReader(fr);
            while(br.ready()){
                aux+= br.readLine() + "\n";
            }
            br.close();
            fr.close();
        } catch(FileNotFoundException e){
            System.out.println("ERRO, ARQUIVO NÃO ENCONTRADO.");
        } catch(IOException e){
            System.out.println("ERRO AO SALVAR.");
        }
        return aux;
    }
}