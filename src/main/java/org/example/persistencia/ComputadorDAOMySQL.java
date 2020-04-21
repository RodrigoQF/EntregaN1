package org.example.persistencia;


import org.example.entidades.Computador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputadorDAOMySQL implements ComputadorDAO {

    private String createSQL="INSERT INTO computador (marca, processador , tamanho_disco , qnt_ram) VALUES(?,?,?,?)";
    private String readSQL = "SELECT * FROM computador";
    private String updateSQL="UPDATE computador SET marca=?, processador=?, tamanho_disco=? , qnt_ram=? WHERE id=?";
    private String deleteSQL="DELETE FROM computador WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();



    @Override
    public boolean create(Computador computador) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);
            stm.setString(1,computador.getMarca());
            stm.setString(2,computador.getProcessador());
            stm.setInt(3,computador.getTamanho_disco());
            stm.setInt(4,computador.getQnt_ram());
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
    public List<Computador> read() {

            Connection conexao = mysql.getConnection();
            List<Computador> sistemas = new ArrayList();

            try {
                PreparedStatement pstm = conexao.prepareStatement(readSQL);
                ResultSet rs = pstm.executeQuery();

                while (rs.next()) {
                    Computador computador = new Computador();
                    computador.setMarca(rs.getString("marca"));
                    computador.setProcessador(rs.getString("processador"));
                    computador.setTamanho_disco(rs.getInt("tamanho_disco"));
                    computador.setQnt_ram(rs.getInt("qnt_ram"));
                    sistemas.add(computador);
                }

                return sistemas ;

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
            return sistemas;
        }



    @Override
    public boolean update(Computador computador) {
        return false;
    }

    @Override
    public boolean delete(Computador computador) {
        return false;
    }
}




