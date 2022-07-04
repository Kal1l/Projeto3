package client;
import java.io.*;
import java.util.Scanner;

import manipulacao.Manipulacao;

public class Cliente {
    //adIciona novo cliente
    public void novoCliente(){
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
        System.out.println(dados.length);
        //mostra os dados do cliente pesquisado
        String mostraDados = "Nome :" + dados[0] + ",Idade :" + dados[1] + ", CPF :" + dados[2];
        System.out.println(mostraDados);
    }

    public void listarClientes() throws Exception{
        File cliente = new File(Manipulacao.clientes);
        for(File clientes : cliente.listFiles()){
            String[] dados = Manipulacao.lerArquivo(clientes).split(";");
            System.out.println("====================================");
            System.out.print("Nome :" + dados[0] + ",Idade :" + dados[1] + ", CPF :" + dados[2]);
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
        System.out.println("Digite o nome :");
        String novoNome = in.nextLine();
        if(novoNome.equals(" ")){
            novoNome = dados[0];
        }
        System.out.println("Digite a idade :");
        String novaIdade = in.nextLine();
        if(novaIdade.equals(" ")){
            novaIdade = dados[1];
        }
        System.out.println("Digite o CPF :");
        String novoCPF = in.nextLine();
        if(novoCPF.equals((" "))){
            novoCPF = dados[2];
        }
        //junta todos os dados alterados e reescreve o arquivo
        String salvaDados = novoNome + ";" + novaIdade + ";" + novoCPF;
        Manipulacao.escreverArquivoApagando(cliente, salvaDados);
    }
}
