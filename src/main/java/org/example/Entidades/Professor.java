package org.example.Entidades;

public class Professor {
    private int id;
    private String nome;
    private String email;
    private String area;

    public Professor(int id, String nome, String email, String area) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.area = area;
    }

    public Professor(String nome, String email, String area) {
        this.nome = nome;
        this.email = email;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
