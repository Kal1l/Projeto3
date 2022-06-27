package client;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import manipulacao.Manipulacao;

public class Cliente {
    private String nome;
    private int idade;
    private int cpf;

    //adciona novo cliente
    public void novoCliente(){
        String dados = "";
        //número de cadastro do cliente na loja
        String cadastro = "";
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
        dados += nome + "," + idade + "," + cpf + "\n";
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
        String[] dados = Manipulacao.lerArquivo(file).split(",");
        System.out.println(dados.length);
        String mostraDados = "Nome :" + dados[0] + ",Idade :" + dados[1] + ", CPF :" + dados[2];
        System.out.println(mostraDados);
    }

    public void listarClientes() throws Exception{
        File cliente = new File(Manipulacao.clientes);
        for(File clientes : cliente.listFiles()){
            String[] dados = Manipulacao.lerArquivo(clientes).split(",");
            System.out.println("====================================");
            System.out.print("Nome :" + dados[0] + ",Idade :" + dados[1] + ", CPF :" + dados[2]);
        }
        System.out.println("====================================");
    }
    //getters / setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int idade) {
        this.cpf = idade;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
