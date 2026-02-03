package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {
        inicio();
    }
        public static void inicio(){
        while(true) {
            System.out.println("==== SISTEMA ACADÊMICO ====");
            System.out.println("""
                    1 - Gerenciar Alunos\n
                    2 - Gerenciar Professores\n
                    3 - Gerenciar Provas\n 
                    4 - Gerenciar Notas\n
                    0 - Encerrar Sistema\n
                    >
                    """);
            int opcao = SC.nextInt();
            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
    public static void menuAluno(){
        while(true){
        System.out.println("""
                ==== MENU DE ALUNOS ====\n
                1 - Cadastrar Alunos\n
                2 - Listar Alunos\n
                3 - Buscar Alunos por ID\n
                4 - Atualizar Aluno\n
                5 - Remover Aluno\n
                0 - Voltar ao menu principal\n
                >
              
                """);
        int opcao = SC.nextInt();
        switch (opcao){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 0:
                inicio();
                break;

        }
        }
    }
    public static void menuProfessores(){
        while(true){
            System.out.println("""
                    ==== MENU DE PROFESSORES ====\n
                    1 - Cadastrar Professor\n
                    2 - Listar Professores\n
                    3 - Buscar Professores por ID\n
                    0 - Voltar ao menu principal\n
                    >
                    """);
            int opcao = SC.nextInt();
            switch (opcao){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    inicio();
                    break;
            }
        }
    }
    public static void menuProvas(){
        while(true){
            System.out.println("""
                    ==== MENU DE PROVAS ====\n
                    1 - Lançar nota\n
                    2 - Consultar nota\n
                    3 - Emitir boletim do Aluno\n
                    0 - Voltar ao menu principal\n
                    >                   
                    """);
            int opcao = SC.nextInt();
            switch (opcao){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    inicio();
                    break;
            }
        }
    }
    public static void menuNotas(){
        while(true){
            System.out.println("""
                    ==== MENU NOTAS ====\n
                    1 - Lançar nota\n
                    2 - Consultar nota\n
                    3 - Emitir boletim do aluno\n
                    0 - Voltar ao menu principal\n
                   >
                    """);
        int opcao = SC.nextInt();
        switch (opcao){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 0:
                inicio();
                break;
        }
        }

    }
}

