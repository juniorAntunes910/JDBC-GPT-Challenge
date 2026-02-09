package org.example;

import org.example.DAO.AlunoDao;
import org.example.DAO.ProfessorDao;
import org.example.DAO.ProvaDao;
import org.example.Entidades.Aluno;
import org.example.Entidades.Professor;
import org.example.Entidades.Prova;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
                    menuAluno();
                    break;
                case 2:
                    menuProfessores();
                    break;
                case 3:
                    menuProvas();
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
                cadastrarAluno();
                break;
            case 2:
                listarAluno();
                break;
            case 3:
                buscarAlunoPorId();
                break;
            case 4:
                atualizarAluno();
                break;
            case 5:
                removerAluno();
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
                    cadastrarProfessor();
                    break;
                case 2:
                    listarProfessores();
                    break;
                case 3:
                    buscarProfessorPorID();
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
                    1 - Criar prova vinculada ao professor
                    2 - Listar provas por professor
                    0 - Voltar ao menu principal
                    >                   
                    """);
            int opcao = SC.nextInt();
            switch (opcao){
                case 1:
                    criarProvas();
                    break;
                case 2:
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
    //Menu Aluno
    public static void cadastrarAluno(){
        System.out.println("Digite o nome do aluno: ");
        SC.nextLine();
        String nome = SC.nextLine();
        System.out.println("Digite o email do aluno: ");
        String email = SC.nextLine();
        System.out.println("Digite a idade do aluno: ");
        int idade = SC.nextInt();
        Aluno aluno = new Aluno(nome, email, idade);
        var dao = new AlunoDao();
        dao.salvar(aluno);
        System.out.println("Aluno Cadastrado com sucesso - " + aluno.getNome());
    }
    public static void listarAluno(){
        var Dao = new AlunoDao();
        ArrayList<Aluno> listaAlunos = Dao.listarAluno();
        for(Aluno aluno : listaAlunos){
            System.out.println(aluno);
        }
    }
    public static void buscarAlunoPorId(){
        System.out.println("Insira o ID do Aluno que você deseja buscar: ");
        int id = SC.nextInt();
        var dao = new AlunoDao();
        Aluno aluno = dao.buscaAlunoPorID(id);
        if(aluno == null){
            System.out.println("Aluno Não existe");
        }
        System.out.println(aluno);
    }
    public static void atualizarAluno(){
        System.out.println("Insira o ID do Aluno que você deseja atualizar: ");
        int id = SC.nextInt();
        var dao = new AlunoDao();
        Aluno aluno = dao.buscaAlunoPorID(id);
        if(aluno == null) {
            System.out.println("Aluno inexistente");
            menuAluno();

        }
        System.out.println("Insira o novo nome do Aluno ");
        SC.nextLine();
        String novoNome = SC.nextLine();
        System.out.println("Insira o novo email do Aluno: ");
        String novoEmail = SC.nextLine();
        System.out.println("Insira a nova Idade do Aluno: ");
        int novaIdade = SC.nextInt();
        aluno.setNome(novoNome);
        aluno.setEmail(novoEmail);
        aluno.setIdade(novaIdade);
        dao.atualizarAluno(aluno);
        System.out.println("Aluno atualizado com sucesso");
    }
    public static void removerAluno(){
        System.out.println("Insira o ID do Aluno que você deseja remover: ");
        int idRemove = SC.nextInt();
        var dao = new AlunoDao();
        Aluno alunoRemove = dao.buscaAlunoPorID(idRemove);
        dao.removerAluno(alunoRemove);
        System.out.println("Aluno Removido com sucesso");
    }
    //Menu Professor
    public static void cadastrarProfessor(){
        System.out.println("Insira o nome do Professor: ");
        SC.nextLine();
        String nome = SC.nextLine();
        System.out.println("Insira o email do Professor: ");
        String email = SC.nextLine();
        System.out.println("Insira a area do Professor: ");
        String area = SC.nextLine();
        Professor professor = new Professor(nome, email, area);
        var dao = new ProfessorDao();
        dao.cadastrar(professor);

    }
    public static void listarProfessores(){
        System.out.println("Lista de Professores: ");
        var dao = new ProfessorDao();
        ArrayList<Professor> listaProf = dao.listarProfessores();
        for(Professor professor : listaProf){
            System.out.println(professor);
        }
    }
    public static void buscarProfessorPorID(){
        System.out.println("Insira o ID do professor que você deseja achar: ");
        int id = SC.nextInt();
        var dao = new ProfessorDao();
        Professor professor = dao.buscarProfessorID(id);
        System.out.println(professor);
    }
    //Provas
    public static void criarProvas(){
        System.out.println("Insira o titulo da prova: ");
        SC.nextLine();
        String titulo = SC.nextLine();
        System.out.println("Data de Hoje : " + LocalDate.now());
        LocalDate data = LocalDate.now();
        System.out.println("Insira o ID do Professor que esta criando a prova: ");
        int idProfessor = SC.nextInt();
        Prova prova = new Prova(titulo, data, idProfessor);
        var dao = new ProvaDao();
        dao.criarProva(prova);
    }
    public static void listarProvasPorProfessor(int id){
        String sql = """
                
                """;
    }
}

