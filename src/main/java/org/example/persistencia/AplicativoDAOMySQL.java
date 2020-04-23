package org.example.persistencia;

import org.example.entidades.Aplicativo;
import org.example.entidades.Computador;
import org.example.entidades.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicativoDAOMySQL implements AplicativoDAO{

        private String createSQL="INSERT INTO aplicativo (nome, desenvolvedor, nrm_downloads) VALUES(?,?,?)";
        private String readSQL = "SELECT * FROM aplicativo";
        private String updateSQL="UPDATE aplicativo SET nome=?, desenvolvedor=?, nrm_downloads=? WHERE id=?";
        private String deleteSQL="DELETE FROM aplicativo WHERE id=?";

        private final MySQLConnection mysql = new MySQLConnection();


        @Override
        public boolean createaplicativo(Aplicativo aplicativo) {
            Connection conexao = mysql.getConnection();
            try {
                PreparedStatement stm = conexao.prepareStatement(createSQL);
                stm.setString(1,aplicativo.getNome());
                stm.setString(2,aplicativo.getDesenvolvedor());
                stm.setInt(3,aplicativo.getNrm_downloads());
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

        @Override
        public List<Aplicativo> readaplicativo() {
            Connection conexao = mysql.getConnection();
            List<Aplicativo> store = new ArrayList();

            try {
                PreparedStatement pstm = conexao.prepareStatement(readSQL);
                ResultSet rs = pstm.executeQuery();

                while (rs.next()) {
                    Aplicativo aplicativo = new Aplicativo();
                    aplicativo.setId(rs.getLong("id"));
                    aplicativo.setNome(rs.getString("nome"));
                    aplicativo.setDesenvolvedor(rs.getString("desenvolvedor"));
                    aplicativo.setNrm_downloads(rs.getInt("nrm_downloads"));

                    store.add(aplicativo);
                }

                return store ;

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
            return store;
        }

    @Override
    public boolean updateaplicativo(Aplicativo aplicativo) {
        Connection conexao = mysql.getConnection();
        int resultado = -1;
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);
            stm.setString(1,aplicativo.getNome());
            stm.setString(2,aplicativo.getDesenvolvedor());
            stm.setInt(3,aplicativo.getNrm_downloads());
            stm.setLong(4,aplicativo.getId());

            resultado=stm.executeUpdate();
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

    @Override
    public boolean deleteaplicativo(Aplicativo aplicativo) {
        Connection conexao = mysql.getConnection();
        int resultado = -1;
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);
            stm.setLong(1,aplicativo.getId());
            stm.execute();
            resultado=stm.executeUpdate();
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


