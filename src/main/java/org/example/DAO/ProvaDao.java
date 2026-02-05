package org.example.DAO;

import org.example.Conexao;
import org.example.Entidades.Prova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
