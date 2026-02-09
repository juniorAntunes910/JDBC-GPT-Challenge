package org.example.DAO;

import org.example.Conexao;
import org.example.Entidades.Nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class notaDao {
    public void lancarNota(Nota nota){
        String sql = """
                INSERT INTO nota
                VALUES(?,?,?)
                """;
        try(Connection conn = Conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, nota.getAlunoID());
            stmt.setInt(2, nota.getProvaID());
            stmt.setDouble(3, nota.getNota());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Nota> consultarNota(int id){
        String sql = """
                SELECT aluno_id, prova_id, nota
                FROM nota
                WHERE aluno_id = ?
                """;
        try(Connection conn = Conexao.conectar()){
            ArrayList<Nota> listarNota = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next()){
                listarNota.add(new Nota(rs.getInt("aluno_id"), rs.getInt("prova_id"), rs.getDouble("nota")));
            }
            return listarNota;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public Nota emitirBoletim(int id){
        String sql = """
                SELECT aluno_id, prova_id, nota
                FROM nota
                WHERE aluno_id = ?
                """;
        try(Connection conn = Conexao.conectar()) {
            ArrayList<Nota> listarNota = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Nota(rs.getInt("aluno_id"), rs.getInt("prova_id"), rs.getDouble("nota"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
