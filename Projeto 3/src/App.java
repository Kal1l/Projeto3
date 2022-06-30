import java.util.Scanner;

import manipulacao.Manipulacao;
import menu.*;

public class App {
    public static void main(String[] args) throws Exception {
        Manipulacao.gerarPastas();
        MenuCliente menucliente=new MenuCliente();
        MenuFilme menuFilme = new MenuFilme();
        Scanner in=new Scanner(System.in);
        int opção=0;/*int opção2=0;*/
        while(opção!=3){
            System.out.println("BEM VINDO, O QUE DESEJA ?\n1-CLIENTE\n2-FILME\n3-SAIR");
            opção=in.nextInt();
            if(opção==1){
                menucliente.mostrarMenu();
            }
            else if(opção==2){
                menuFilme.mostrarMenuFilme();
            } else {
                System.out.println("MAMA BOLA 3000 <3");
            }
        }
    }
}
