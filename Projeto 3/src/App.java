import java.util.Scanner;

import filme.Ranking;
import manipulacao.Manipulacao;
import menu.*;

public class App {
    public static void main(String[] args) throws Exception {
        Manipulacao.gerarPastas();
        MenuCliente menucliente=new MenuCliente();
        MenuFilme menuFilme = new MenuFilme();
        Scanner in=new Scanner(System.in);
        int opção=0;
        while(opção!=3){
            System.out.println("BEM VINDO, O QUE DESEJA ?\n1-CLIENTE\n2-FILME\n3-SAIR");
            opção=in.nextInt();
            if(opção==1){
                menucliente.mostrarMenu();
            }
            else if(opção==2){
                menuFilme.mostrarMenuFilme();
            } 
            else if(opção==3){
                Ranking ranking = new Ranking();
                ranking.rankearFilmes();
            }
            else if(opção==4){
                System.out.println("SAINDO");
                System.exit(1);
            }
            else {
                System.out.println("OPÇÃO INVÁLIDA");
            }
        }
        in.close();
    }
}
