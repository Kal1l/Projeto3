package client;
import java.io.*;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private int idade;
    private int cpf;

    public void gerarPastas(){
        File pasta = new File("Diretório");
        pasta.mkdir();
        File f1 = new File(pasta,"clientes");
        f1.mkdir();
        File f2 = new File(pasta,"filmes");
        f2.mkdir();
        File f3 = new File(pasta,"filmes alugados");
        f3.mkdir();
    }

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
        File dir= new File("Diretório/clientes/"+ cadastro);
        dir.mkdir();
        File file = new File(dir, nome + ".txt");

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

        try{
            FileWriter fWriter = new FileWriter(file);
            BufferedWriter bRWriter = new BufferedWriter(fWriter);
            bRWriter.write(dados);
            bRWriter.close();
            fWriter.close();

            FileReader fReader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(fReader);
            String aux = bReader.readLine();
            while (aux!=null) {
                aux = bReader.readLine();
            }
            bReader.close();
            fReader.close();
        }catch(IOException e){System.out.println("ERRO AO SALVAR");}   
          
    }

        //OBS: Utilizar esse método após verificar que o cliente não possui nenhum filme, se houver, tem que fazer a devolução primeiro;
        public void deletarCliente() throws FileNotFoundException{
        String cadastro = "";
        Scanner in = new Scanner(System.in);
        System.out.println("INSIRA O NÚMERO DE CADASTRO DO CLIENTE :");
        cadastro = in.nextLine();
        File file = new File("Diretório/clientes/"+cadastro);
        file.delete();
        System.out.println("CLIENTE REMOVIDO");
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
