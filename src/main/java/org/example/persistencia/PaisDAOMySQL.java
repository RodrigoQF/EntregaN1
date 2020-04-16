package org.example.persistencia;

import org.example.entidades.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PaisDAOMySQL implements PaisDAO {
    private String createSQL="INSERT INTO pais (nome, continente, populacao) VALUES(?,?,?)";
    private String readSQL = "SELECT * FROM pais";
    private String updateSQL="UPDATE pais SET nome=?, continente=?, populacao=? WHERE id=?";
    private String deleteSQL="DELETE FROM pais WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();



    @Override
    public boolean create(Pais pais) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);
            stm.setString(1,pais.getNome());
            stm.setInt(2,pais.getContinente());
            stm.setLong(3,pais.getPopulacao());
            int registro = stm.executeUpdate();
            return (registro>0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Pais> read() {
        return null;
    }

    @Override
    public boolean update(Pais pais) {
        return false;
    }

    @Override
    public boolean delete(Pais pais) {
        return false;
    }
}
