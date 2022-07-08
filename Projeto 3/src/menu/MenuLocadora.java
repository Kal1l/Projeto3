package menu;
import java.util.Scanner;

import filme.*;
public class MenuLocadora {
    public void mostraMenu(){

        AlugarDevolver alugar = new AlugarDevolver();
        Sugerir sugerir = new Sugerir();
        Ranking rankear = new Ranking();
        Scanner in = new Scanner(System.in);
        System.out.println("DIGITE O CADASTRO DO CLIENTE: ");
        String cad=in.nextLine();
        int opcao;
        boolean flag = false;
        while(!flag){
            System.out.println("OPCAO DESEJADA:\n1-ALUGAR FILME(S)\n2-DEVOLVER FILME(S)\n3-SUGERIR FILMES\n4-FILMES MAIS ALUGADOS\n5-VOLTAR");
            opcao=in.nextInt();
            switch(opcao){
            case 1:
                try {
                    alugar.alugarFilme(cad);
                } catch (Exception e) { e.printStackTrace();}
                break;
            case 2:
                try{
                    alugar.devolverFilme(cad);
                } catch(Exception e) {e.printStackTrace();}
                break;
            case 3:
                System.out.println("SUGERIR POR:\n1-GENERO\n2-ATOR(ES)");
                int opttmp=in.nextInt();
                if(opttmp==1){
                    sugerir.sugestaoGenero();
                }
                else if(opttmp==2){
                    sugerir.sugestaoAtores();
                }
                else{
                    System.out.println("OPCAO INVALIDA");
                }
                break;
            case 4:
                rankear.rankearFilmes();
                break;
            case 5:
                flag = true;
                break;
            default:
                System.out.println("OPÇÃO INVALIDA");
                break;
            }

        }
    }
}