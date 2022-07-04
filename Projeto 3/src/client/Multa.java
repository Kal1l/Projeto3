package client;

import java.io.File;
import java.util.Scanner;

import manipulacao.Manipulacao;

public class Multa {
    public void aplicarMulta(){
        Scanner in = new Scanner(System.in);
        System.out.println("DIGITE O CODIGO DO CLIENTE");
        String codigo=in.nextLine();
        System.out.println("DIGITE OS DIAS DE ATRASO");
        int dias=in.nextInt();
        File file = new File(Manipulacao.filmesAlugados + codigo + ".txt");
        String[] dados=  Manipulacao.lerArquivo(file).split("\n");
        int i=(dados.length)-1;//ISSO AQUI PROVAVELMENTE VAI DAR ERRADO
        double valor = Double.parseDouble(dados[i].replaceAll(",","."))+(1.20*dias);
        dados[i]+="Multa : R$ "+valor;
        String salvarDados = "";
        for(int cont=0;cont<dados.length;cont++){
            String aux=dados[cont];
            salvarDados += aux+"\n";
        }
        Manipulacao.escreverArquivoApagando(file, salvarDados); 
        in.close();
    }

    public void removerMulta(){
        Scanner in = new Scanner(System.in);
        System.out.println("DIGITE O CODIGO DO CLIENTE");
        String codigo=in.nextLine();
        File file = new File(Manipulacao.filmesAlugados + codigo + ".txt");
        String[] dados=  Manipulacao.lerArquivo(file).split("\n");
        int i=(dados.length)-1;//ISSO AQUI PROVAVELMENTE VAI DAR ERRADO
        dados[i]+="Multa : R$ "+0.0;
        String salvarDados = "";
        for(int cont=0;cont<dados.length;cont++){
            String aux=dados[cont];
            salvarDados += aux+"\n";
        }
        Manipulacao.escreverArquivoApagando(file, salvarDados); 
        in.close();
    }

    public boolean verificarMulta(String codigo){
        File file = new File(Manipulacao.filmesAlugados + codigo + ".txt");
        String[] dados=  Manipulacao.lerArquivo(file).split("\n");
        int i=(dados.length)-1;//ISSO AQUI PROVAVELMENTE VAI DAR ERRADO
        if(dados[i] == "Multa : R$ 0.0"){
            return false;
        }
        else{
            return true;
        }
    }
}
