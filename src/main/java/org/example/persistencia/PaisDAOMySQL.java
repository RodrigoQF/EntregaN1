package org.example.persistencia;

import org.example.entidades.Computador;
import org.example.entidades.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaisDAOMySQL implements PaisDAO {
    private String createSQL="INSERT INTO pais (nome, continente, populacao) VALUES(?,?,?)";
    private String readSQL = "SELECT * FROM pais";
    private String updateSQL="UPDATE pais SET nome=?, continente=?, populacao=? WHERE id=?";
    private String deleteSQL="DELETE FROM pais WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();


    //insert
    @Override
    public boolean createpais(Pais pais) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);
            stm.setString(1,pais.getNome());
            stm.setInt(2,pais.getContinente());
            stm.setLong(3,pais.getPopulacao());
            int registro = stm.executeUpdate();
            return (registro > 0);
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

    //select
    @Override
    public List<Pais> readpais() {
        Connection conexao = mysql.getConnection();
        List<Pais> planeta = new ArrayList();

        try {
            PreparedStatement pstm = conexao.prepareStatement(readSQL);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Pais pais = new Pais();
                pais.setId(rs.getLong("id"));
                pais.setNome(rs.getString("nome"));
                pais.setPopulacao(rs.getLong("populacao"));
                pais.setContinente(rs.getInt("continente"));

                planeta.add(pais);
            }
            return planeta ;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return planeta;
    }

    @Override
    public boolean updatepais (Pais pais) {
        Connection conexao = mysql.getConnection();
         int resultado = -1;
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);
            stm.setString(1,pais.getNome());
            stm.setInt(2,pais.getContinente());
            stm.setLong(3,pais.getPopulacao());
            stm.setLong(4,pais.getId());

            resultado = stm.executeUpdate();


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
        return (resultado >0);
    }

    @Override
    public boolean deletepais(Pais pais) {
        int resultado = -1;

        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);
            stm.setLong(1,pais.getId());
            stm.execute();
            resultado = stm.executeUpdate();
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
        return (resultado>0);
    }

}
