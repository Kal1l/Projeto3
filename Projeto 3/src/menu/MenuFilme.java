package menu;

import java.util.Scanner;

import filme.AlugarDevolver;
import filme.Filme;
import filme.Ranking;
import filme.Sugerir;

public class MenuFilme {
    Filme filme = new Filme();
    AlugarDevolver alugar = new AlugarDevolver();
    Sugerir sugerir = new Sugerir();
    Ranking rankear = new Ranking();
    public void mostrarMenuFilme() throws Exception{
        Scanner in = new Scanner(System.in);
        int opcao;
        boolean flag = false;
        while(!flag){
            System.out.println("O QUE DESEJA REALIZAR?\n1-ADICIONAR FILME\n2-DELETAR FILME\n3-PESQUISAR FILME\n4-LISTAR FILMES\n5-ALTERAR FILME\n6-ALUGAR FILME(S)\n7-DEVOLVER FILMES\n8-SUGERIR FILMES\n9-RANKING DE FILMES\n10-VOLTAR");
            opcao = in.nextInt();
            switch(opcao){
                case 1:
                    filme.adicionarFilme();
                    break;
                case 2:
                    filme.deletarFilme();
                    break;
                case 3:
                    filme.pesquisarFilme();
                    break;
                case 4:
                    filme.listarFilmes();
                    break;
                case 5:
                    try {
                        filme.alterarDados();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        alugar.alugarFilme();
                    } catch (Exception e) { e.printStackTrace();}
                    break;
                case 7:
                    try{
                        alugar.devolverFilme();
                    } catch(Exception e) {e.printStackTrace();}
                    break;
                case 8:
                    sugerir.sugestao();
                    break;
                case 9:
                    rankear.rankearFilmes();
                    break;
                case 10:
                    flag = true;
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
                    break;
            }
        }
    }
}
