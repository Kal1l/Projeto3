package client;

import java.io.File;
import java.util.Scanner;

import manipulacao.Manipulacao;

public class Multa {
    public void aplicarMulta() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("DIGITE O CODIGO DO CLIENTE");
        String codigo=in.nextLine();
        System.out.println("DIGITE OS DIAS DE ATRASO");
        int dias=in.nextInt();
        File file = new File(Manipulacao.filmesAlugados + codigo + ".txt");
        String[] dados =  Manipulacao.lerArquivo(file).split("\n");
        String[] dados2 = dados[0].split(";");
        double valor2 = Double.parseDouble(dados2[1].replaceAll(",","."));
        int filmesTotal = Integer.parseInt(dados2[2]);
        double valor = valor2 + (1.20*dias*filmesTotal);
        String salvarDados = "";
        for(int cont=0;cont<dados.length-1;cont++){
            String aux=dados[cont];
            salvarDados += aux+"\n";
        }
        salvarDados += "Multa à pagar : R$ " + valor + "\n";
        Manipulacao.escreverArquivoApagando(file, salvarDados); 
    }

    public boolean verificarMulta(String codigo) throws Exception{
        File file = new File(Manipulacao.filmesAlugados + codigo + ".txt");
        String[] dados=  Manipulacao.lerArquivo(file).split("\n");
        int i=(dados.length)-1;//ISSO AQUI PROVAVELMENTE VAI DAR ERRADO
        if(dados[i] == "Multa : R$ 0.0"){
            return false;
        }
        else{
            System.out.println("CLIENTE NÃO POSSUI MULTA");
            return true;
        }
    }
}
