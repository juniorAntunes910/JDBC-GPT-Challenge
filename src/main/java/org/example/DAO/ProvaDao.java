package org.example.DAO;

import org.example.Conexao;
import org.example.Entidades.Professor;
import org.example.Entidades.Prova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProvaDao {
    public void criarProva(Prova prova){
        String sql = """
                INSERT INTO prova(titulo,data,professor_id)
                VALUES(?,?,?)
                """;
        try (Connection conn = Conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, prova.getTitulo());
            stmt.setDate(2, java.sql.Date.valueOf(prova.getData()));
            stmt.setInt(3, prova.getProfessorID());
            stmt.executeUpdate();
            if(stmt == null){
                System.out.println("Prova possui dados incorretos");
            }
            System.out.println("Prova Criada com sucesso");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Prova> listarProvasPorProfessor(int id){
        String sql = """
                SELECT id,titulo,data,professor_id
                from prova
                WHERE professor_id = ?
                """;
        try(Connection conn = Conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Prova> listaProva = new ArrayList<>();
            while(rs.next()){
                listaProva.add(new Prova(rs.getInt("id"), rs.getString("titulo"), rs.getDate("data").toLocalDate(), rs.getInt("professor_id")));
            }
            return listaProva;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
