package menu;

import java.util.Scanner;

import filme.Filme;

public class MenuFilme {
    Filme filme = new Filme();
    public void mostrarMenuFilme(){
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        int opcao;
        boolean flag = false;
        String espera = "";
        while(!flag){
            System.out.println("O QUE DESEJA REALIZAR?\n1-ADICIONAR FILME\n2-DELETAR FILME\n3-PESQUISAR FILME\n4-LISTAR FILMES\n5-VOLTAR");
            opcao = in.nextInt();
            switch(opcao){
                case 1:
                    filme.adicionarFilme();
                    break;
                case 2:
                    filme.deletarFilme();
                    espera = in2.nextLine();
                    break;
                case 3:
                    filme.pesquisarFilme();
                    espera = in2.nextLine();
                    break;
                case 4:
                    filme.listarFilmes();
                    espera = in2.nextLine();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
                    espera = in2.nextLine();
                    break;
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }
}
