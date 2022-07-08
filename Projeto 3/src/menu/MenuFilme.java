package menu;

import java.util.Scanner;

import filme.*;


public class MenuFilme {
    Filme filme = new Filme();
    public void mostrarMenuFilme() throws Exception{
        Scanner in = new Scanner(System.in);
        int opcao;
        boolean flag = false;
        while(!flag){
            System.out.println("OPCAO DESEJADA:\n1-ADICIONAR FILME\n2-DELETAR FILME\n3-PESQUISAR FILME\n4-LISTAR FILMES\n5-ALTERAR DADOS FILME\n6-VOLTAR");
            opcao = in.nextInt();
            switch(opcao){
                case 1:
                    try {
                         filme.adicionarFilme();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {  
                        filme.deletarFilme();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        filme.pesquisarFilme();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        filme.listarFilmes();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        filme.alterarDados();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    flag = true;
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
                    break;
            }
        }
    }
}
