import java.util.Scanner;

import manipulacao.Manipulacao;
import menu.*;

public class App {
    public static void main(String[] args) throws Exception {
        Manipulacao.gerarPastas();
        MenuCliente menucliente=new MenuCliente();
        MenuFilme menuFilme = new MenuFilme();
        MenuLocadora menuLocadora=new MenuLocadora();
        Scanner in=new Scanner(System.in);
        boolean flag = true;
        int opção=0;
        while(flag){
            System.out.println("BEM VINDO, O QUE DESEJA ?\n1-OPERACOES DOS CLIENTES \n2-OPERACOES DOS FILMES\n3-OPERACOES DA LOCADORA\n3-SAIR");
            opção=in.nextInt();
            switch(opção){
                case 1:
                menucliente.mostrarMenu();
                break;
                case 2:
                menuFilme.mostrarMenuFilme();
                break;
                case 3:
                menuLocadora.mostraMenu();
                break;
                case 4:
                flag=false;
                break;
                default:
                System.out.println("OPCAO INVALIDA");
            }
        }
        in.close();
    }
}
