package org.example.Entidades;

public class Nota {
    private int id;
    private int alunoID;
    private int provaID;
    private double nota;

    public Nota(int id, int alunoID, int provaID, double nota) {
        this.id = id;
        this.alunoID = alunoID;
        this.provaID = provaID;
        this.nota = nota;
    }

    public Nota(int alunoID, int provaID, double nota) {
        this.alunoID = alunoID;
        this.provaID = provaID;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlunoID() {
        return alunoID;
    }

    public void setAlunoID(int alunoID) {
        this.alunoID = alunoID;
    }

    public int getProvaID() {
        return provaID;
    }

    public void setProvaID(int provaID) {
        this.provaID = provaID;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", alunoID=" + alunoID +
                ", provaID=" + provaID +
                ", nota=" + nota +
                '}';
    }
}
