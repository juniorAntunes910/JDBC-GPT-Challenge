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
                    1 - Gerenciar Alunos
                    2 - Gerenciar Professores
                    3 - Gerenciar Provas
                    4 - Gerenciar Notas
                    0 - Encerrar Sistema
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
                ==== MENU DE ALUNOS ====
                1 - Cadastrar Alunos
                2 - Listar Alunos
                3 - Buscar Alunos por ID
                4 - Atualizar Aluno
                5 - Remover Aluno
                0 - Voltar ao menu principal
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
                    ==== MENU DE PROFESSORES ====
                    1 - Cadastrar Professor
                    2 - Listar Professores
                    3 - Buscar Professores por ID
                    0 - Voltar ao menu principal
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
                    ==== MENU DE PROVAS ====
                    1 - Lançar nota
                    2 - Consultar nota
                    3 - Emitir boletim do Aluno
                    0 - Voltar ao menu principal
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
                    ==== MENU NOTAS ====
                    1 - Lançar nota
                    2 - Consultar nota
                    3 - Emitir boletim do aluno
                    0 - Voltar ao menu principal
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

