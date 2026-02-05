package org.example.DAO;

import org.example.Conexao;
import org.example.Entidades.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorDao {
    public void cadastrar(Professor professor) {
        String sql = """
                INSERT INTO professor(nome, email, area)
                VALUES(?,?,?)
                """;
        try (Connection conn = Conexao.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getArea());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Professor> listarProfessores() {
        String sql = """
                SELECT id, nome, email, area 
                FROM professor
                """;
        try (Connection conn = Conexao.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Professor> listaProf = new ArrayList<>();
            while (rs.next()) {
                listaProf.add(new Professor(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("area")));
            }
            return listaProf;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Professor buscarProfessorID(int id) {
        String sql = """
                SELECT id, nome, email, area FROM professor
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Professor professor = new Professor(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("area"));
                return professor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
