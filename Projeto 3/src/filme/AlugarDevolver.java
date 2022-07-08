package filme;

import java.io.File;
import java.util.Scanner;

import client.Cliente;
import manipulacao.Manipulacao;

/*
Problemas:
    Caso do cliente alugando filmes pra classificações maiores ainda não resolvido

 Lista de afazeres:
    Adicionar quando o cliente não existir
    Adicionar o IOException e o FileNotFound
 */

public class AlugarDevolver {
    public void alugarFilme(String codigo) throws Exception{
        Scanner in = new Scanner(System.in);
        File verificaFilmeAlugado = new File(Manipulacao.filmesAlugados + codigo + ".txt");
        //verifica se o cliente possui algum filme alugado
        if(verificaFilmeAlugado.length() == 0) {
            System.out.println("ESCOLHA UM FILME DA LISTA A SEGUIR(DIGITE O CÓDIGO DO FILME) :");
            File filmes = new File(Manipulacao.filmes);
            for(File filme: filmes.listFiles()){
                String[] dados = Manipulacao.lerArquivo(filme).split(";");
                System.out.println("===============================");
                System.out.print("Codigo do filme :" + filme.getName().replace(".txt", ""));
                System.out.println(", Titulo : " +dados[0]+", Genero :"+dados[2]+", Classificação :"+dados[3]+",Preço R$ :" + dados[4]);
            }
            System.out.println("===============================");
            File cliente = new File(Manipulacao.clientes+codigo+".txt");
            String[] string = Manipulacao.lerArquivo(cliente).split(";");
            int idade= Integer.parseInt(string[1]);
            boolean flag = true;

            //valores dos códigos do filme
            String codigoFilme1 = new String();
            String codigoFilme2 = new String();
            String codigoFilme3 = new String();
            
            //prevenindo um cliente de alugar um filme com a classificação maior que a sua idade
            while(flag){
                String vefCodigoFilme1=in.nextLine();
                String vefCodigoFilme2=in.nextLine();
                String vefCodigoFilme3=in.nextLine();
                //prevenção da condição: classificação < idade
                boolean flag2 = true;

                //lê todos os arquivos de filme
                for(File filme : filmes.listFiles()){
                    String codigoDoFilmeProcura = filme.getName().replace(".txt","");
                    String[] dados = Manipulacao.lerArquivo(filme).split(";");
                    //caso encontre um dos códigos que foi dado
                    if(vefCodigoFilme1.equals(codigoDoFilmeProcura) || vefCodigoFilme2.equals(codigoDoFilmeProcura) ||
                        codigoFilme3.equals(codigoDoFilmeProcura)){
                            //pega a classificação e transforma em inteiro
                            int classificacao = Integer.parseInt(dados[3]);
                            if(classificacao > idade){
                                //caso a condição seja quebrada
                                flag2=false;
                            }
                    }
                }
                    if(flag2){
                        //caso a condição seja cumprida, copia as strings escritas pelo usuário para uma variável externa do loop
                        codigoFilme1=vefCodigoFilme1;
                        codigoFilme2=vefCodigoFilme2;
                        codigoFilme3=vefCodigoFilme3;
                        //desativa e quebra o loop
                        flag=false;
                        break;
                    } else {
                        System.out.println("CLASSIFICAÇÃO IMPRÓPRIA PRO CLIENTE");
                }
            }   

            double preco = 0;
            int filmesTotal = 0;
            String aluguel = "";
            String salvaDados = "";
            for(File filme : filmes.listFiles()){
                String codigoDoFilmeProcura = filme.getName().replace(".txt","");
                String[] dados = Manipulacao.lerArquivo(filme).split(";");
                if(codigoFilme1.equals(codigoDoFilmeProcura) || codigoFilme2.equals(codigoDoFilmeProcura) ||
                    codigoFilme3.equals(codigoDoFilmeProcura)){
                        //preço de todos os filmes  juntos
                        preco += Double.parseDouble(dados[4].replaceAll(",", "."));
                        //string com o preço e nome do filme alugados
                        aluguel+=dados[0] + ";R$ " + dados[4] + "\n";
                        //adiciona ao histórico do cliente
                        File historicoCliente=new File(Manipulacao.historicoClientes+codigo+".txt");
                        Manipulacao.escreverArquivo(historicoCliente, dados[0]+";"+dados[1]+";"+dados[2]+"\n");
                        //adiciona ao histórico geral de filmes
                        File historicoFilmes=new File(Manipulacao.historicoFilmes,"historico.txt");
                        Manipulacao.escreverArquivo(historicoFilmes, dados[0]+"\n");
                        //adiciona ao total de filmes
                        filmesTotal++;
                }
            }
            //data em que os filmes foram alugados
            System.out.println("INSIRA A DATA DE HOJE(DIA/MES/ANO):");
            String data=new String();
            while(true){
                String data2=in.nextLine();
                if(data2.contains("/")){
                    data= data2;
                    break;
                }
                else{
                    System.out.println("INSIRA A DATA NO FORMATO CORRETO");
                }
            }
            //junta tudo e escreve no arquivo
            salvaDados+= "Total R$; " + preco + " ;"+filmesTotal+" ;"+ data +"\n" + "\n" + aluguel;
            File aluguelFilme = new File(Manipulacao.filmesAlugados + codigo + ".txt");
            Manipulacao.escreverArquivoApagando(aluguelFilme, salvaDados);
            System.out.println("ALUGUEL REALIZADO");
        } else {
            System.out.println("CLIENTE POSSUI PENDENCIAS EM NOSSO SISTEMA");
        }
    }

    public void devolverFilme(String codigo) throws Exception {
        Scanner in = new Scanner(System.in);
        File verificaFilmeAlugado = new File(Manipulacao.filmesAlugados + codigo + ".txt");
        //quando o cliente possui algum filme e não possui multa
        if(verificaFilmeAlugado.length() != 0) {
            File aluguelFilme = new File(Manipulacao.filmesAlugados + codigo + ".txt");
            String[] dados= Manipulacao.lerArquivo(aluguelFilme).split("\n");
            String[] dados2=dados[0].split(";");
            int option=0;
            String valor ="";
            System.out.println("ALUGOU EM: "+dados2[3]);
            System.out.println("CLIENTE FEZ A DEVOLUÇÃO COM ATRASO?\n1-SIM\n2-NÃO");
            option=in.nextInt();
            switch(option){
                case 1:
                Cliente cliente = new Cliente();
                cliente.aplicarMulta(codigo);
                int i= dados.length-1;
                valor=dados[i];
                aluguelFilme.delete();
                System.out.println(valor);
                break;
                case 2:
                valor=dados2[0].replace(";",":")+dados2[1];
                aluguelFilme.delete();
                System.out.println(valor);
                break;
            }     
        }
        else{
            System.out.println("NÃO FOI POSSÍVEL REALIZAR A DEVOLUÇÃO");
        }
    }
}
