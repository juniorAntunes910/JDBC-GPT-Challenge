package org.example.DAO;

import org.example.Conexao;
import org.example.Entidades.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDao {

    public void salvar(Aluno aluno) {
        String sql = """
                INSERT INTO aluno(nome, email, idade)
                VALUES(?, ?, ?)
                """;
        try (Connection conn = Conexao.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setInt(3, aluno.getIdade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Aluno> listarAluno() {
        ArrayList<Aluno> listaalunos = new ArrayList<>();
        String sql = """
                SELECT nome, email, idade
                FROM aluno
                """;
        try (Connection conn = Conexao.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Foi");
                listaalunos.add(new Aluno(rs.getString("nome"), rs.getString("email"), rs.getInt("idade")));
            }
            return listaalunos;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Aluno buscaAlunoPorID(int id) {
        String sql = """
                SELECT id, nome, email, idade
                FROM aluno
                WHERE id = ?        
                """;
        try (Connection conn = Conexao.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getInt("idade"));
                return aluno;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizarAluno(Aluno aluno) {
        String sql = """
                UPDATE aluno
                SET nome = ?, email = ?, idade = ?
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setInt(3, aluno.getIdade());
            stmt.setInt(4, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerAluno(Aluno aluno) {
        String sql = """
                DELETE FROM nota
                WHERE aluno_id = ?""";
        String sql2 = """
                DELETE FROM aluno
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, aluno.getId());
            stmt.executeUpdate();
            stmt = conn.prepareStatement(sql2);
            stmt.setInt(1, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
