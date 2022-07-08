package client;
import java.io.*;
import java.util.Scanner;

import manipulacao.Manipulacao;

public class Cliente {
    //adIciona novo cliente
    public void novoCliente() throws Exception{
        String dados = "";
        String cadastro = "";   //número de cadastro do cliente na loja
        String idade = "";
        String cpf = "";
        String nome = "";

        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);

        System.out.println("INSIRA O NÚMERO DE CADASTRO DO CLIENTE:"); 
        cadastro = in.nextLine();
        System.out.println("INSIRA O NOME DO CLIENTE :");
        nome = in2.nextLine();
        // cadastro/nome.txt
        File file = new File(Manipulacao.clientes + cadastro + ".txt");
        File historicoCliente=new File(Manipulacao.historicoClientes+cadastro+".txt");
        historicoCliente.createNewFile();
        File alugados = new File(Manipulacao.filmesAlugados + cadastro + ".txt");
        alugados.createNewFile();



        System.out.println("INSIRA A IDADE DO CLIENTE :");
        idade = in2.nextLine();
        System.out.println("INSIRA O CPF DO CLIENTE :");
        cpf = in2.nextLine();
        if (cpf.length() == 11){
        //String para juntar tudo, na hora de escrever
        dados += nome + ";" + idade + ";" + cpf + "\n";
        }
        else{
            System.out.println("CPF INSERIDO INCORRETAMENTE");
        }

        Manipulacao.escreverArquivo(file, dados);  
          
    }

        //OBS: Utilizar esse método após verificar que o cliente não possui nenhum filme, se houver, tem que fazer a devolução primeiro;
    public void deletarCliente() throws FileNotFoundException{
        String cadastro = "";
        Scanner in = new Scanner(System.in);
        System.out.println("INSIRA O NÚMERO DE CADASTRO DO CLIENTE :");
        cadastro = in.nextLine();
        File file = new File(Manipulacao.clientes + cadastro + ".txt");
        file.delete();
        System.out.println("CLIENTE REMOVIDO");
    }

    public void pesquisarCliente() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("INSIRA O NÚMERO DE CADASTRO DO CLIENTE :");
        String cadastro = in.nextLine();
        File file = new File(Manipulacao.clientes + cadastro + ".txt");
        String[] dados = Manipulacao.lerArquivo(file).split(";");
        //mostra os dados do cliente pesquisado
        String mostraDados = "Nome :" + dados[0] + ",Idade :" + dados[1] + ", CPF :" + dados[2];
        System.out.println(mostraDados);
    }

    public void listarClientes() throws Exception{
        File cliente = new File(Manipulacao.clientes);
        for(File clientes : cliente.listFiles()){
            String[] dados = Manipulacao.lerArquivo(clientes).split(";");
            System.out.println("====================================");
            System.out.print("Cadastro :" + clientes.getName().replace(".txt", ""));
            System.out.print(",Nome :" + dados[0] + ",Idade :" + dados[1] + ", CPF :" + dados[2]);
        }
        System.out.println("====================================");
    }

    public void alterarDados() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o codigo do cliente : ");
        String codigo = in.nextLine();
        File cliente = new File(Manipulacao.clientes + codigo + ".txt");
        //separa os dados do cliente em várias strings
        String[] dados = Manipulacao.lerArquivo(cliente).split(";");
        //Altera os dados de um por um
        System.out.println("INSIRA O NOME :");
        String novoNome = in.nextLine();
        if(novoNome.equals(" ")){
            novoNome = dados[0];
        }
        System.out.println("INSIRA A IDADE :");
        String novaIdade = in.nextLine();
        if(novaIdade.equals(" ")){
            novaIdade = dados[1];
        }
        System.out.println("INSIRA O CPF :");
        String novoCPF = in.nextLine();
        if(novoCPF.equals((" "))){
            novoCPF = dados[2];
        }
        //junta todos os dados alterados e reescreve o arquivo
        String salvaDados = novoNome + ";" + novaIdade + ";" + novoCPF;
        Manipulacao.escreverArquivoApagando(cliente, salvaDados);
    }

    public void aplicarMulta(String codigo) throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("DIGITE OS DIAS DE ATRASO");
        int dias=in.nextInt();
        File file = new File(Manipulacao.filmesAlugados + codigo + ".txt");
        String[] dados =  Manipulacao.lerArquivo(file).split("\n");
        String[] dados2 = dados[0].split(";");
        double valor = Double.parseDouble(dados2[1].replaceAll(",","."));
        double filmesTotal = Double.parseDouble(dados2[2]);
        double valor2 = valor + (1.20*dias*filmesTotal);
        String salvarDados = "";
        for(int cont=0;cont<dados.length;cont++){
            String aux=dados[cont];
            salvarDados += aux+"\n";
        }
        salvarDados += "Total c/multa: R$ " + valor2 + "\n" + "";
        Manipulacao.escreverArquivoApagando(file, salvarDados); 
    }
}
