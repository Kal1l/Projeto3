package menu;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.catalog.Catalog;

import client.Cliente;

public class MenuCliente {
    Cliente cliente = new Cliente();
    public void mostrarMenu(){
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        boolean flag = false;
        int opcao;
        String espera = "";
        while(!flag){
            
            System.out.println("O QUE DESEJA REALIZAR?\n1-ADICIONAR CLIENTE\n2-DELETAR CLIENTE\n3-PESQUISAR CLIENTE\n4-LISTAR CLIENTES\n5-ALTERAR CLIENTE\n6-VOLTAR");
            opcao = in.nextInt();
            switch(opcao){
                case 1:
                        try {
                            cliente.novoCliente();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    break;
                case 2:
                        try {
                            cliente.deletarCliente();
                        } catch(FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        espera = in2.nextLine();
                    break;
                case 3:
                    try{
                        cliente.pesquisarCliente();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    espera = in2.nextLine();
                    break;
                case 4:
                    try{
                        cliente.listarClientes();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    espera = in2.nextLine();
                    break;
                case 5:
                    try{
                        cliente.alterarDados();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    flag = true;
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
                    espera = in2.nextLine();
                    break;
            }
            /*System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");*/
        }
    }
}
