package menu;

import java.io.FileNotFoundException;
import java.util.Scanner;

import client.Cliente;
/*
Lista de afazeres 
    Adicionar métodos de multa ao menu
    Criar o método de Ranking de filmes do cliente
*/
import client.Multa;
public class MenuCliente {
    Cliente cliente = new Cliente();
    Multa multa=new Multa();
    public void mostrarMenu(){
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        int opcao;
        while(!flag){
            System.out.println("O QUE DESEJA REALIZAR?\n1-ADICIONAR CLIENTE\n2-DELETAR CLIENTE\n3-PESQUISAR CLIENTE\n4-LISTAR CLIENTES\n5-ALTERAR CLIENTE\n6-MULTAR CLIENTE\n7-REMOVER MULTA DE CLIENTE\n8-VOLTAR");
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
                    break;
                case 3:
                    try{
                        cliente.pesquisarCliente();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try{
                        cliente.listarClientes();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try{
                        cliente.alterarDados();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try{
                        multa.aplicarMulta();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 7:
                try{
                    multa.removerMulta();
                }catch(Exception e){
                    e.printStackTrace();
                }
                    break;
                case 8:
                    flag = true;
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
                    break;
            }
        }
    }
}
