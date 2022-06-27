package menu;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.catalog.CatalogException;

import client.Cliente;

public class MenuCliente {
    Cliente cliente = new Cliente();
    public void mostrarMenu(){
        System.out.println("O QUE DESEJA REALIZAR?\n1-ADICIONAR CLIENTE\n2-DELETAR CLIENTE\n3-PESQUISAR CLIENTE\n4-LISTAR CLIENTES\n5-VOLTAR");
        Scanner in = new Scanner(System.in);
        int opção;
        while(true){
            opção=in.nextInt();
            switch(opção){
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
            }
        }
    }
}
