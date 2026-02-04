package org.example.Entidades;

import java.time.LocalDate;

public class Prova {
    private int id;
    private String titulo;
    private LocalDate data;
    private int professorID;

    public Prova(int id, String titulo, LocalDate data, int professorID) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.professorID = professorID;
    }

    public Prova(String titulo, LocalDate data, int professorID) {
        this.titulo = titulo;
        this.data = data;
        this.professorID = professorID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    @Override
    public String toString() {
        return "Prova{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", data=" + data +
                ", professorID=" + professorID +
                '}';
    }
}
